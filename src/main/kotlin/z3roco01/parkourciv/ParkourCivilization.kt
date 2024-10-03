package z3roco01.parkourciv

import net.fabricmc.api.ModInitializer
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object ParkourCivilization : ModInitializer {
	val MOD_ID = "parkour_civ"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {


		logger.info("init done !!")
	}

	/**
	 * makes an id with the path specified
	 * @param path the path of the [Identifier]
	 * @return the fully qualified [Identifier]
	 */
	fun mkId(path: String) = Identifier.of(MOD_ID, path)
}