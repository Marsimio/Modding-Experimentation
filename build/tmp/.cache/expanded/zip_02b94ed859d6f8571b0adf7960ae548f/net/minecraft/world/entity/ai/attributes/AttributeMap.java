package net.minecraft.world.entity.ai.attributes;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.mojang.logging.LogUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class AttributeMap {
   private static final Logger LOGGER = LogUtils.getLogger();
   private final Map<Attribute, AttributeInstance> attributes = Maps.newHashMap();
   private final Set<AttributeInstance> dirtyAttributes = Sets.newHashSet();
   private final AttributeSupplier supplier;

   public AttributeMap(AttributeSupplier p_22144_) {
      this.supplier = p_22144_;
   }

   private void onAttributeModified(AttributeInstance p_22158_) {
      if (p_22158_.getAttribute().isClientSyncable()) {
         this.dirtyAttributes.add(p_22158_);
      }

   }

   public Set<AttributeInstance> getDirtyAttributes() {
      return this.dirtyAttributes;
   }

   public Collection<AttributeInstance> getSyncableAttributes() {
      return this.attributes.values().stream().filter((p_22184_) -> {
         return p_22184_.getAttribute().isClientSyncable();
      }).collect(Collectors.toList());
   }

   @Nullable
   public AttributeInstance getInstance(Attribute p_22147_) {
      return this.attributes.computeIfAbsent(p_22147_, (p_22188_) -> {
         return this.supplier.createInstance(this::onAttributeModified, p_22188_);
      });
   }

   @Nullable
   public AttributeInstance getInstance(Holder<Attribute> p_250010_) {
      return this.getInstance(p_250010_.value());
   }

   public boolean hasAttribute(Attribute p_22172_) {
      return this.attributes.get(p_22172_) != null || this.supplier.hasAttribute(p_22172_);
   }

   public boolean hasAttribute(Holder<Attribute> p_248893_) {
      return this.hasAttribute(p_248893_.value());
   }

   public boolean hasModifier(Attribute p_22155_, UUID p_22156_) {
      AttributeInstance attributeinstance = this.attributes.get(p_22155_);
      return attributeinstance != null ? attributeinstance.getModifier(p_22156_) != null : this.supplier.hasModifier(p_22155_, p_22156_);
   }

   public boolean hasModifier(Holder<Attribute> p_250299_, UUID p_250415_) {
      return this.hasModifier(p_250299_.value(), p_250415_);
   }

   public double getValue(Attribute p_22182_) {
      AttributeInstance attributeinstance = this.attributes.get(p_22182_);
      return attributeinstance != null ? attributeinstance.getValue() : this.supplier.getValue(p_22182_);
   }

   public double getBaseValue(Attribute p_22186_) {
      AttributeInstance attributeinstance = this.attributes.get(p_22186_);
      return attributeinstance != null ? attributeinstance.getBaseValue() : this.supplier.getBaseValue(p_22186_);
   }

   public double getModifierValue(Attribute p_22174_, UUID p_22175_) {
      AttributeInstance attributeinstance = this.attributes.get(p_22174_);
      return attributeinstance != null ? attributeinstance.getModifier(p_22175_).getAmount() : this.supplier.getModifierValue(p_22174_, p_22175_);
   }

   public double getModifierValue(Holder<Attribute> p_251534_, UUID p_250438_) {
      return this.getModifierValue(p_251534_.value(), p_250438_);
   }

   public void removeAttributeModifiers(Multimap<Attribute, AttributeModifier> p_22162_) {
      p_22162_.asMap().forEach((p_296658_, p_296659_) -> {
         AttributeInstance attributeinstance = this.attributes.get(p_296658_);
         if (attributeinstance != null) {
            p_296659_.forEach((p_296663_) -> {
               attributeinstance.removeModifier(p_296663_.getId());
            });
         }

      });
   }

   public void addTransientAttributeModifiers(Multimap<Attribute, AttributeModifier> p_22179_) {
      p_22179_.forEach((p_296660_, p_296661_) -> {
         AttributeInstance attributeinstance = this.getInstance(p_296660_);
         if (attributeinstance != null) {
            attributeinstance.removeModifier(p_296661_.getId());
            attributeinstance.addTransientModifier(p_296661_);
         }

      });
   }

   public void assignValues(AttributeMap p_22160_) {
      p_22160_.attributes.values().forEach((p_22177_) -> {
         AttributeInstance attributeinstance = this.getInstance(p_22177_.getAttribute());
         if (attributeinstance != null) {
            attributeinstance.replaceFrom(p_22177_);
         }

      });
   }

   public ListTag save() {
      ListTag listtag = new ListTag();

      for(AttributeInstance attributeinstance : this.attributes.values()) {
         listtag.add(attributeinstance.save());
      }

      return listtag;
   }

   public void load(ListTag p_22169_) {
      for(int i = 0; i < p_22169_.size(); ++i) {
         CompoundTag compoundtag = p_22169_.getCompound(i);
         String s = compoundtag.getString("Name");
         Util.ifElse(BuiltInRegistries.ATTRIBUTE.getOptional(ResourceLocation.tryParse(s)), (p_22167_) -> {
            AttributeInstance attributeinstance = this.getInstance(p_22167_);
            if (attributeinstance != null) {
               attributeinstance.load(compoundtag);
            }

         }, () -> {
            LOGGER.warn("Ignoring unknown attribute '{}'", (Object)s);
         });
      }

   }
}