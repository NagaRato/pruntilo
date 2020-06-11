# pruntilo
*REST-API to administrate all your borrow stuff.*

## Summary
The concept is simple, pruntilo contains a list with stuff (elements you borrow) and members (people you do allow to borrow your stuff).
In between are loanings, they contain an ID, the date a member took stuff (take), and the date on which you agreed he will bring the stuff back (bring).

## Assumptions of the results.
When you call a certain entity you get always the simple properties of the entity you asked for, plus a summary of the container and list entities it belongs to.
When you call a list of entities (filtered or not) you will receive a list of summarizes of the entities in the list.