package net.marsim.zejzamod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class FlameTongueItem extends SwordItem {
    public FlameTongueItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = target.level();
        if (!world.isClientSide) {
            target.setSecondsOnFire(3);

            world.explode(
                    attacker,
                    attacker.getX(),
                    attacker.getY(),
                    attacker.getZ(),
                    3.0F,
                    Level.ExplosionInteraction.NONE
            );
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entityLiving) {
        // Explosion logic goes here
        if (!world.isClientSide && entityLiving instanceof Player) {
            world.explode(
                    null,
                    entityLiving.getX(),
                    entityLiving.getY(),
                    entityLiving.getZ(),
                    3.0F,
                    Level.ExplosionInteraction.NONE
            );
        }

        // Optional: Implement item durability reduction or other effects

        return super.finishUsingItem(stack, world, entityLiving);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32; // Duration in ticks (e.g., 32 ticks for quick eat action)
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT; // Eating animation
    }


}
