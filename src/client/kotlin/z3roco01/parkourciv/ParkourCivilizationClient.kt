package z3roco01.parkourciv

import net.fabricmc.api.ClientModInitializer
import org.slf4j.LoggerFactory

object ParkourCivilizationClient : ClientModInitializer {
	val logger = LoggerFactory.getLogger(ParkourCivilization.MOD_ID + "_client")

	override fun onInitializeClient() {


		logger.info("client init finished !!")
	}
}