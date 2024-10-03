package z3roco01.parkourciv

import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object ParkourCivilization : ModInitializer {
	val MOD_ID = "parkour_civ"
    val logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {


		logger.info("init done !!")
	}
}