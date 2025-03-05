package net.thedarkpeasant.togglenametags.event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderNameTagEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thedarkpeasant.togglenametags.ClientVariables;
import net.thedarkpeasant.togglenametags.ToggleNametags;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = ToggleNametags.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEventBusSubscriber {
    @SubscribeEvent
    public static void disableNametags(RenderNameTagEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player && !ClientVariables.shouldShowNametags()) {
            event.setResult(Event.Result.DENY);
        }
    }
}