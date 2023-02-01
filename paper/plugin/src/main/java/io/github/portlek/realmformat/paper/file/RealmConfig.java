package io.github.portlek.realmformat.paper.file;

import io.github.portlek.realmformat.paper.configurate.Config;
import io.github.portlek.realmformat.paper.misc.MongoCredential;
import java.io.File;
import java.nio.file.Path;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.loader.ConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@Getter
@ConfigSerializable
public final class RealmConfig implements Config {

  @NotNull
  private final ConfigurationLoader<?> loader;

  @Setting
  private Path fileLoaderPath = new File("realms").toPath();

  @Setting
  private MongoCredential mongo = MongoCredential
    .builder()
    .address("localhost")
    .port(27017)
    .database("minecraft")
    .collection("realms")
    .username("root")
    .password("root123")
    .build();

  public RealmConfig(@NotNull final ConfigurationLoader<?> loader) {
    this.loader = loader;
  }
}