package com.example.exampleaddon.elements.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import com.example.exampleaddon.ExampleAddon;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

// This information is the documentation,
// You can use a plugin such as SkriptHubDocsTool to automatically convert these into a JSON to your docs to websites that support it!
@Name("My Effect")
@Description("An awesome effect")
@Examples("my effect")
@Since("1.0")
public class EffMyEffect extends Effect { // To register an effect, extend the class with Effect

    static {
        Skript.registerEffect(EffMyEffect.class, "my effect"); // It is very important you use [].class when registering.
    }

    // Normally this method is generated at the bottom, but in my experience it's a lot better to move it up.
    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true; // It is VERY important that you return true here, or Skript will not see this as a valid Effect.
    }

    @Override
    protected void execute(Event event) {
        System.out.println("Woah!");
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        return "my effect"; // When using a variable in your effect, use it in this format: "variable.toString(event, debug)"
    }

}
