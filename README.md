# Instant Wall

A tiny Fabric mod for Minecraft Java Edition 26.2.

## What it does

- Craft two vertically stacked cobblestone walls into one **Instant Wall**.
- The item looks like a stone button and stacks to 64.
- Use it on the top of a block to place two cobblestone walls, one above the other.
- The Instant Wall is consumed unless the player is in Creative mode.
- Deployment fails without consuming the item if either destination block is occupied.
- Breaking the deployed wall gives the two normal cobblestone wall blocks back.

## Build on Windows

This project targets Java 25, which Minecraft 26.2 requires.

From this folder, run:

```powershell
C:\Gradle\bin\gradle.bat build
```

The playable JAR will be created in:

```text
build\libs\instant-wall-fabric-26.2-1.0.0.jar
```

Copy that JAR into your Minecraft `mods` folder. Fabric Loader and Fabric API
for Minecraft 26.2 must also be installed.

## Test command

```text
/give @s instantwall:instant_wall 64
```
