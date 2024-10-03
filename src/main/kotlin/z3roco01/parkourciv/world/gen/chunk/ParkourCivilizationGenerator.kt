package z3roco01.parkourciv.world.gen.chunk

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryOps
import net.minecraft.registry.RegistryWrapper
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.structure.StructureSet
import net.minecraft.structure.StructureTemplateManager
import net.minecraft.util.math.BlockPos
import net.minecraft.world.ChunkRegion
import net.minecraft.world.HeightLimitView
import net.minecraft.world.Heightmap
import net.minecraft.world.StructureWorldAccess
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeKeys
import net.minecraft.world.biome.source.BiomeAccess
import net.minecraft.world.biome.source.FixedBiomeSource
import net.minecraft.world.chunk.Chunk
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.StructureAccessor
import net.minecraft.world.gen.chunk.Blender
import net.minecraft.world.gen.chunk.ChunkGenerator
import net.minecraft.world.gen.chunk.DebugChunkGenerator
import net.minecraft.world.gen.chunk.VerticalBlockSample
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator
import net.minecraft.world.gen.noise.NoiseConfig
import java.util.concurrent.CompletableFuture
import java.util.function.Function
import java.util.stream.Stream

class ParkourCivilizationGenerator(biome: RegistryEntry.Reference<Biome>): ChunkGenerator(FixedBiomeSource(biome)) {
    companion object {
        val CODEC: MapCodec<out ParkourCivilizationGenerator> = RecordCodecBuilder.mapCodec{instance ->
            return@mapCodec instance.group(RegistryOps.getEntryCodec(BiomeKeys.PLAINS)).apply(instance, ::ParkourCivilizationGenerator)
        }
    }

    override fun getCodec(): MapCodec<out ParkourCivilizationGenerator> = CODEC

    override fun carve(chunkRegion: ChunkRegion, seed: Long, noiseConfig: NoiseConfig, biomeAccess: BiomeAccess,
                       structureAccessor: StructureAccessor, chunk: Chunk, carverStep: GenerationStep.Carver) {
    }

    override fun buildSurface(region: ChunkRegion, structures: StructureAccessor,
                              noiseConfig: NoiseConfig, chunk: Chunk) {
    }

    override fun populateEntities(region: ChunkRegion) {
    }

    override fun populateNoise(blender: Blender, noiseConfig: NoiseConfig, structureAccessor: StructureAccessor,
                               chunk: Chunk): CompletableFuture<Chunk> {
        for(x in 0..<16) {
            for(z in 0..<16) {
                if(x % 2 == 0 && z % 2 == 0)
                    chunk.setBlockState(BlockPos(x, 0, z), Blocks.GRASS_BLOCK.defaultState, false)
            }
        }

        return CompletableFuture.completedFuture(chunk)
    }

    override fun createStructurePlacementCalculator(
        structureSetRegistry: RegistryWrapper<StructureSet>?,
        noiseConfig: NoiseConfig?,
        seed: Long
    ): StructurePlacementCalculator {
        return StructurePlacementCalculator.create(noiseConfig, 0, biomeSource, Stream.empty())
    }

    override fun generateFeatures(world: StructureWorldAccess, chunk: Chunk, structureAccessor: StructureAccessor) {
    }

    override fun getWorldHeight(): Int = 256

    override fun getSeaLevel(): Int = 0

    override fun getMinimumY(): Int = -64


    override fun getHeight(x: Int, z: Int, heightmap: Heightmap.Type, world: HeightLimitView,
                           noiseConfig: NoiseConfig): Int = 0

    override fun getColumnSample(x: Int, z: Int, world: HeightLimitView,
                                 noiseConfig: NoiseConfig): VerticalBlockSample {
        return VerticalBlockSample(
            world.bottomY, arrayOf<BlockState>()
        )
    }

    override fun getDebugHudText(text: MutableList<String>, noiseConfig: NoiseConfig, pos: BlockPos) {
        TODO("Not yet implemented")
    }
}