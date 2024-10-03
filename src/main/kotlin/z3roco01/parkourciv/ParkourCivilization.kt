package z3roco01.parkourciv

import net.fabricmc.api.ModInitializer
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory
import z3roco01.parkourciv.world.gen.chunk.ParkourCivilizationGenerator

object ParkourCivilization : ModInitializer {
	val MOD_ID = "parkour_civ"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		Registry.register(Registries.CHUNK_GENERATOR, mkId("parkour_civilization"), ParkourCivilizationGenerator.CODEC)

		logger.info("init done !!")
	}

	/**
	 * makes an id with the path specified
	 * @param path the path of the [Identifier]
	 * @return the fully qualified [Identifier]
	 */
	fun mkId(path: String) = Identifier.of(MOD_ID, path)
}