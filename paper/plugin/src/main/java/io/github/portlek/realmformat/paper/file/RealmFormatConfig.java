package io.github.portlek.realmformat.paper.file;

import io.github.portlek.realmformat.paper.internal.configurate.Config;
import io.github.portlek.realmformat.paper.internal.configurate.Configs;
import io.github.portlek.realmformat.paper.internal.misc.MongoCredential;
import io.github.portlek.realmformat.paper.internal.misc.Services;
import java.nio.file.Path;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.configurate.loader.ConfigurationLoader;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Setting;

@Getter
@ConfigSerializable
public final class RealmFormatConfig implements Config {

  @NotNull
  private final ConfigurationLoader<?> loader = Configs.yaml(
    Services.load(Path.class).resolve("config.yaml")
  );

  @Setting
  private String fileLoaderPath = "realms";

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
}
