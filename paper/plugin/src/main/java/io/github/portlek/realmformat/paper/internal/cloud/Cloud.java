package io.github.portlek.realmformat.paper.internal.cloud;

import cloud.commandframework.Command;
import cloud.commandframework.arguments.standard.StringArgument;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.minecraft.extras.MinecraftHelp;
import cloud.commandframework.paper.PaperCommandManager;
import com.google.common.reflect.TypeToken;
import lombok.SneakyThrows;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public interface Cloud {
  TypeToken<PaperCommandManager<CommandSender>> KEY = new TypeToken<>() {};

  @NotNull
  @SneakyThrows
  static PaperCommandManager<CommandSender> create(@NotNull final Plugin plugin) {
    final var manager = PaperCommandManager.createNative(
      plugin,
      CommandExecutionCoordinator.simpleCoordinator()
    );
    try {
      manager.registerBrigadier();
    } catch (final Exception ignored) {}
    try {
      manager.registerAsynchronousCompletions();
    } catch (final Exception ignored) {}
    return manager;
  }

  static void registerHelpCommand(
    @NotNull final PaperCommandManager<CommandSender> commandManager,
    @NotNull final Command.Builder<CommandSender> builder,
    @NotNull final String command
  ) {
    final var helpHandler = MinecraftHelp.createNative("/" + command + " help", commandManager);
    helpHandler.commandFilter(c ->
      c.getArguments().stream().findFirst().orElseThrow().getName().equals(command)
    );
    final var help = builder
      .literal("help", "?")
      .argument(StringArgument.optional("query", StringArgument.StringMode.GREEDY))
      .handler(context ->
        helpHandler.queryCommands(context.getOrDefault("query", ""), context.getSender())
      );
    commandManager.command(help);
  }
}
