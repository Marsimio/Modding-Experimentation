package net.marsim.zejzamod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.phys.Vec3;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

public class FireballWandItem extends Item {

    public FireballWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            Vec3 lookVec = player.getLookAngle();
            Vec3 playerPos = player.position().add(0, player.getEyeHeight(), 0);

            // Create a LargeFireball entity representing the traveling explosion
            LargeFireball fireball = new LargeFireball(world, player,
                    lookVec.x, lookVec.y, lookVec.z, 1);
            fireball.setPos(playerPos.x + lookVec.x * 2, playerPos.y, playerPos.z + lookVec.z * 2);
            world.addFreshEntity(fireball);

            // Play shooting sound
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.GHAST_WARN, SoundSource.PLAYERS, 0.5F,
                    1F / (player.getRandom().nextFloat() * 0.4F + 0.8F));

            // Apply item damage or consume item if needed
            if (!player.getAbilities().instabuild) {
                itemStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            }

            return InteractionResultHolder.success(itemStack);
        }

        return InteractionResultHolder.pass(itemStack);
    }
}