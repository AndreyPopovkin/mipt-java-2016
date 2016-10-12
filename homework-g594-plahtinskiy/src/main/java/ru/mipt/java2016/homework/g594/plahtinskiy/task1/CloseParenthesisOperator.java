package ru.mipt.java2016.homework.g594.plahtinskiy.task1;

import ru.mipt.java2016.homework.base.task1.ParsingException;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by VadimPl on 13.10.16.
 */
public final class CloseParenthesisOperator extends Lexeme {

    @Override
    protected int priority() throws ParsingException {
        try {
            throw new ParsingException("Logical error: close parenthesis is never checked for priority");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    protected void makeOperation(Stack<NumberLexeme> results) throws ParsingException {
        throw new ParsingException("Logical error: close parenthesis can't make any operation");
    }

    @Override
    public void addLexeme(Stack<NumberLexeme> results, Stack<Lexeme> operations) throws Exception {
        try {
            while (operations.peek().priority() != 0) {
                Lexeme operation = operations.pop();
                operation.makeOperation(results);
            }
        } catch (EmptyStackException e) {
            throw new ParsingException("No parenthesis balance");
        }
        operations.pop();
    }
}
