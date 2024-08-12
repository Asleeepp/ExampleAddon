package com.example.exampleaddon.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EvtMyEvent extends SkriptEvent {

    static {
        Skript.registerEvent("My Custom Event", EvtMyEvent.class, EntityDeathEvent.class, "my custom event");
        // Skript already has this event (EntityDeathEvent), but for the purpose of the addon, let's pretend it doesn't.
    }

    @Override
    public boolean init(Literal<?> @NotNull [] args, int matchedPattern, @NotNull SkriptParser.ParseResult parseResult) {
        return true; // It is VERY important that you return true here, or Skript will not see this as a valid Event.
    }

    @Override
    public boolean check(@NotNull Event event) {
        // When dealing with events in Skript, you don't need to implement any logic about event cancellation,
        // as Skript handles all that for you!

        // [insert logic here]
        return event instanceof EntityDeathEvent;
    }

    @Override
    public @NotNull String toString(@Nullable Event event, boolean debug) {
        return "my custom event"; // This is used for debugging/logging purposes.
    }

}
