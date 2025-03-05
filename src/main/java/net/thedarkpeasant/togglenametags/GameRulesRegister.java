package net.thedarkpeasant.togglenametags;

import net.minecraft.world.level.GameRules;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GameRulesRegister {
    public static final GameRules.Key<GameRules.BooleanValue> SHOW_NAMETAGS = GameRules.register("showPlayerNametags",
            GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}
