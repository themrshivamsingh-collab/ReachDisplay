package com.themrshivamsingh.reachdisplay;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ReachDisplay implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HudRenderCallback.EVENT.register(this::onHudRender);
    }

    private void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;

        double reach = client.interactionManager != null ?
            client.interactionManager.getReachDistance() : 3.0;

        String reachString = String.format("Reach: %.2f", reach);

        int screenWidth = client.getWindow().getScaledWidth();
        int x = screenWidth - 5 - client.textRenderer.getWidth(reachString);
        int y = 5;

        drawContext.drawText(
            client.textRenderer, 
            Text.literal(reachString).formatted(Formatting.YELLOW), 
            x, y, 0xFFFFFF, true
        );
    }
}