package io.github.portlek.realmformat.format.realm.v1;

import io.github.portlek.realmformat.format.realm.RealmFormatChunk;
import io.github.portlek.realmformat.format.realm.RealmFormatChunkSection;
import io.github.shiruka.nbt.CompoundTag;
import io.github.shiruka.nbt.ListTag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class RealmFormatChunkV1 implements RealmFormatChunk {

  private int[] biomes;

  private ListTag entities;

  private CompoundTag heightMaps;

  private int maxSection;

  private int minSection;

  private RealmFormatChunkSection[] sections;

  private ListTag tileEntities;

  private int x;

  private int z;
}
