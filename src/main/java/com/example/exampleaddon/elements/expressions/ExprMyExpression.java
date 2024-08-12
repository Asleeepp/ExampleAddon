package com.example.exampleaddon.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

// This information is the documentation,
// You can use a plugin such as SkriptHubDocsTool to automatically convert these into a JSON to your docs to websites that support it!
@Name("My Expression")
@Description("A very cool expression")
@Examples("set {_cool} to cool mode")
@Since("1.0")
public class ExprMyExpression extends SimpleExpression<Boolean> {

    static {
        Skript.registerExpression(ExprMyExpression.class, Boolean.class, ExpressionType.SIMPLE,
                "cool[est] (mode|status)"); // When making syntax, you can use [] to indicate an optional field, and () to indicate a required option.
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        return true; // It is VERY important that you return true here, or Skript will not see this as a valid Expression.
    }

    @Override
    protected @Nullable Boolean[] get(Event event) {
        // Here, you would implement the actual logic to return a Boolean array.
        // But for this expression, let's assume we're always returning true.
        return new Boolean[]{true};
    }

    @Override
    public boolean isSingle() {
        return true; // Indicates that this expression returns a single value.
    }

    @Override
    public Class<? extends Boolean> getReturnType() {
        return Boolean.class; // The return type of this expression.
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "cool mode"; // This is used for debugging/logging purposes.
    }
}
