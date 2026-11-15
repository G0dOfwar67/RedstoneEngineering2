# Redstone Engineering — visual foundation update

Minecraft Java 1.21.11 / Fabric. This update preserves the uploaded registration prototype and adds a coherent first-pass pixel-art asset set.

## Included
- Textures for Receiver, Freezer, Teleporter, Duper, Deleter, Compresser, and Entity Hopper (top/front/side).
- Blockstates and block models for all seven machines.
- Remote item texture and inventory model.
- Engineering Goggles texture/model asset (visual asset only; not registered yet).
- English display names.
- Version 0.1.2.

## Status
This is the visual foundation pass. Remote/Receiver linking, redstone output, custom names/passwords, configuration worktable, machine behaviours, and functional Engineering Goggles are not implemented in this package yet. Machine blocks remain prototypes.

## Cloud build
1. Copy the contents of this folder into the root of your existing GitHub repository, replacing matching files.
2. Commit and push to `main`.
3. Open **Actions** → **Build Redstone Engineering**.
4. Download the successful `RedstoneEngineering-JAR` artifact.
5. Install `redstoneengineering-0.1.2.jar` (not the sources JAR).

Toolchain: Java 21, Gradle 9.8.2, Fabric Loom 1.14.10, Minecraft 1.21.11, Fabric Loader 0.20.1, Fabric API 0.141.6+1.21.11.
