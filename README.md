# Instant Wall

A tiny Fabric mod for Minecraft Java Edition 26.3 that turns common building materials into compact, instant vertical placements.

## Wall items

Each wall item is crafted from two of its matching vanilla wall blocks and deploys a two-block-tall wall:

- Instant Wall
- Instant Mossy Cobblestone Wall
- Instant Stone Brick Wall
- Instant Mossy Stone Brick Wall
- Instant Granite Wall
- Instant Diorite Wall
- Instant Andesite Wall
- Instant Brick Wall
- Instant Sandstone Wall
- Instant Red Sandstone Wall
- Instant Nether Brick Wall
- Instant Red Nether Brick Wall
- Instant End Stone Brick Wall
- Instant Blackstone Wall
- Instant Polished Blackstone Wall
- Instant Polished Blackstone Brick Wall
- Instant Deepslate Brick Wall
- Instant Deepslate Tile Wall
- Instant Mud Brick Wall
- Instant Tuff Wall
- Instant Polished Tuff Wall
- Instant Tuff Brick Wall

Use a wall item on the top of a block to place the two matching vanilla wall blocks above it. The item is consumed unless the player is in Creative mode. Placement fails without consuming the item if the destination is occupied.

## Instant Sand and Instant Gravel

Craft nine sand blocks in a 3x3 crafting grid to make one **Instant Sand**. Craft nine gravel blocks the same way to make one **Instant Gravel**.

Place either item on the top of a block to create a nine-block-tall vertical column. These items can replace water, making them useful for quickly partitioning and draining areas such as ocean monuments.

## Build on Windows

This project targets Java 25, which Minecraft 26.3 requires.

From this folder, run:

```powershell
C:\Gradle\bin\gradle.bat build
```

The playable JAR will be created in:

```text
build\libs\instant-wall-fabric-26.3-1.1.1.jar
```

Copy that JAR into your Minecraft `mods` folder. Fabric Loader and Fabric API for Minecraft 26.3 must also be installed.

## Test commands

```text
/give @s instantwall:instant_wall 64
/give @s instantwall:instant_sand 64
/give @s instantwall:instant_gravel 64
```
