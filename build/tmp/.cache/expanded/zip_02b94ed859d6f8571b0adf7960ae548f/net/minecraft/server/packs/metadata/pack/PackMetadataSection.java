package net.minecraft.server.packs.metadata.pack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.InclusiveRange;

public record PackMetadataSection(Component description, int packFormat, Optional<InclusiveRange<Integer>> supportedFormats) {
   public static final Codec<PackMetadataSection> CODEC = RecordCodecBuilder.create((p_301010_) -> {
      return p_301010_.group(ExtraCodecs.COMPONENT.fieldOf("description").forGetter(PackMetadataSection::description), Codec.INT.fieldOf("pack_format").forGetter(PackMetadataSection::packFormat), InclusiveRange.codec(Codec.INT).optionalFieldOf("supported_formats").forGetter(PackMetadataSection::supportedFormats)).apply(p_301010_, PackMetadataSection::new);
   });
   public static final MetadataSectionType<PackMetadataSection> TYPE = MetadataSectionType.fromCodec("pack", CODEC);
}