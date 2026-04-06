import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ReachDisplayClient implements ModInitializer {
    @Override
    public void onInitialize() {
        // Register HUD render callback
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            displayReachDistance(matrixStack);
        });
    }

    private void displayReachDistance(Object matrixStack) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            double reachDistance = client.interactionManager.getReachDistance();
            String text = String.format("Reach Distance: %.2f", reachDistance);
            client.textRenderer.draw(matrixStack, Text.of(text), 10, 10, 0xFFFFFF);
        }
    }
}