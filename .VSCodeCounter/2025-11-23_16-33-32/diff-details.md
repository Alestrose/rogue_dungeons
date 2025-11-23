# Diff Details

Date : 2025-11-23 16:33:32

Directory c:\\Users\\almcg\\Projects\\rogue_dungeons_repo\\rogue_dungeons

Total : 60 files,  593 codes, 160 comments, 107 blanks, all 860 lines

[Summary](results.md) / [Details](details.md) / [Diff Summary](diff.md) / Diff Details

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [src/main/java/alan/Constants.java](/src/main/java/alan/Constants.java) | Java | 1 | 0 | 0 | 1 |
| [src/main/java/alan/Main.java](/src/main/java/alan/Main.java) | Java | 0 | 0 | 1 | 1 |
| [src/main/java/alan/creatures/ArmorClass.java](/src/main/java/alan/creatures/ArmorClass.java) | Java | 23 | 6 | 8 | 37 |
| [src/main/java/alan/creatures/Creature.java](/src/main/java/alan/creatures/Creature.java) | Java | -1 | 0 | 1 | 0 |
| [src/main/java/alan/creatures/PartyPlayers.java](/src/main/java/alan/creatures/PartyPlayers.java) | Java | 1 | 0 | 0 | 1 |
| [src/main/java/alan/creatures/PlayableCharacter.java](/src/main/java/alan/creatures/PlayableCharacter.java) | Java | 4 | 0 | 5 | 9 |
| [src/main/java/alan/equipment/Weapon.java](/src/main/java/alan/equipment/Weapon.java) | Java | 8 | 2 | 2 | 12 |
| [src/main/java/alan/game\_panel/Card.java](/src/main/java/alan/game_panel/Card.java) | Java | 24 | 0 | 11 | 35 |
| [src/main/java/alan/interfaces/DiceRoll.java](/src/main/java/alan/interfaces/DiceRoll.java) | Java | 2 | 0 | 2 | 4 |
| [src/main/java/alan/player\_class/Barbarian.java](/src/main/java/alan/player_class/Barbarian.java) | Java | 2 | 1 | 0 | 3 |
| [src/main/java/alan/player\_class/Bard.java](/src/main/java/alan/player_class/Bard.java) | Java | 4 | 1 | -1 | 4 |
| [src/main/java/alan/player\_class/Cleric.java](/src/main/java/alan/player_class/Cleric.java) | Java | -4 | 3 | -5 | -6 |
| [src/main/java/alan/player\_class/Druid.java](/src/main/java/alan/player_class/Druid.java) | Java | 4 | 3 | -3 | 4 |
| [src/main/java/alan/player\_class/Fighter.java](/src/main/java/alan/player_class/Fighter.java) | Java | -8 | 1 | -7 | -14 |
| [src/main/java/alan/player\_class/Monk.java](/src/main/java/alan/player_class/Monk.java) | Java | 27 | 11 | 12 | 50 |
| [src/main/java/alan/player\_class/Paladin.java](/src/main/java/alan/player_class/Paladin.java) | Java | 55 | 13 | 24 | 92 |
| [src/main/java/alan/player\_class/PlayerClass.java](/src/main/java/alan/player_class/PlayerClass.java) | Java | 9 | 3 | 3 | 15 |
| [src/main/java/alan/player\_class/SpellSlots.java](/src/main/java/alan/player_class/SpellSlots.java) | Java | 11 | 6 | 4 | 21 |
| [src/main/java/alan/player\_class/features/FeatureAbstract.java](/src/main/java/alan/player_class/features/FeatureAbstract.java) | Java | 12 | 0 | 6 | 18 |
| [src/main/java/alan/player\_class/features/class\_features/LayOnHands.java](/src/main/java/alan/player_class/features/class_features/LayOnHands.java) | Java | 69 | 19 | 16 | 104 |
| [src/main/java/alan/player\_class/features/class\_features/MartialArts.java](/src/main/java/alan/player_class/features/class_features/MartialArts.java) | Java | 67 | 26 | 10 | 103 |
| [src/main/java/alan/player\_class/features/class\_features/Rage.java](/src/main/java/alan/player_class/features/class_features/Rage.java) | Java | 1 | 0 | 0 | 1 |
| [src/main/java/alan/player\_class/features/class\_features/SecondWind.java](/src/main/java/alan/player_class/features/class_features/SecondWind.java) | Java | 36 | 3 | 13 | 52 |
| [src/main/java/alan/player\_class/features/class\_features/UnarmoredDefense.java](/src/main/java/alan/player_class/features/class_features/UnarmoredDefense.java) | Java | 6 | 0 | 0 | 6 |
| [src/main/java/alan/player\_class/features/class\_features/WeaponMastery.java](/src/main/java/alan/player_class/features/class_features/WeaponMastery.java) | Java | -6 | 0 | 0 | -6 |
| [src/main/java/alan/player\_class/features/fighting\_style\_features/Defense.java](/src/main/java/alan/player_class/features/fighting_style_features/Defense.java) | Java | 7 | -2 | 1 | 6 |
| [src/main/java/alan/spells/SpellAbstract.java](/src/main/java/alan/spells/SpellAbstract.java) | Java | 8 | 2 | 2 | 12 |
| [target/classes/alan/Main.class](/target/classes/alan/Main.class) | Java | 2 | 0 | 0 | 2 |
| [target/classes/alan/creatures/ArmorClass$1.class](/target/classes/alan/creatures/ArmorClass$1.class) | Java | 12 | 0 | 0 | 12 |
| [target/classes/alan/creatures/ArmorClass.class](/target/classes/alan/creatures/ArmorClass.class) | Java | 1 | 0 | 5 | 6 |
| [target/classes/alan/creatures/Creature.class](/target/classes/alan/creatures/Creature.class) | Java | -6 | 0 | -1 | -7 |
| [target/classes/alan/creatures/PartyPlayers.class](/target/classes/alan/creatures/PartyPlayers.class) | Java | 2 | 0 | 0 | 2 |
| [target/classes/alan/creatures/PlayableCharacter.class](/target/classes/alan/creatures/PlayableCharacter.class) | Java | 1 | 0 | 0 | 1 |
| [target/classes/alan/equipment/Weapon.class](/target/classes/alan/equipment/Weapon.class) | Java | -1 | 0 | 0 | -1 |
| [target/classes/alan/game\_panel/Card.class](/target/classes/alan/game_panel/Card.class) | Java | 14 | 0 | 0 | 14 |
| [target/classes/alan/grid\_panel/Cell.class](/target/classes/alan/grid_panel/Cell.class) | Java | -2 | 0 | 0 | -2 |
| [target/classes/alan/grid\_panel/GridManager.class](/target/classes/alan/grid_panel/GridManager.class) | Java | -3 | 0 | -1 | -4 |
| [target/classes/alan/player\_class/Barbarian.class](/target/classes/alan/player_class/Barbarian.class) | Java | 3 | 0 | 0 | 3 |
| [target/classes/alan/player\_class/Bard.class](/target/classes/alan/player_class/Bard.class) | Java | 5 | 0 | -1 | 4 |
| [target/classes/alan/player\_class/Cleric$1.class](/target/classes/alan/player_class/Cleric$1.class) | Java | 9 | 0 | 0 | 9 |
| [target/classes/alan/player\_class/Cleric.class](/target/classes/alan/player_class/Cleric.class) | Java | 7 | 0 | 0 | 7 |
| [target/classes/alan/player\_class/Druid$1.class](/target/classes/alan/player_class/Druid$1.class) | Java | 10 | 0 | 0 | 10 |
| [target/classes/alan/player\_class/Druid.class](/target/classes/alan/player_class/Druid.class) | Java | 6 | 0 | 0 | 6 |
| [target/classes/alan/player\_class/Fighter.class](/target/classes/alan/player_class/Fighter.class) | Java | 5 | -1 | 0 | 4 |
| [target/classes/alan/player\_class/Monk.class](/target/classes/alan/player_class/Monk.class) | Java | 19 | 0 | 0 | 19 |
| [target/classes/alan/player\_class/Paladin.class](/target/classes/alan/player_class/Paladin.class) | Java | 42 | 0 | 0 | 42 |
| [target/classes/alan/player\_class/PlayerClass$1.class](/target/classes/alan/player_class/PlayerClass$1.class) | Java | 9 | 0 | 0 | 9 |
| [target/classes/alan/player\_class/PlayerClass.class](/target/classes/alan/player_class/PlayerClass.class) | Java | -53 | 56 | 0 | 3 |
| [target/classes/alan/player\_class/SpellSlots.class](/target/classes/alan/player_class/SpellSlots.class) | Java | 19 | 0 | 0 | 19 |
| [target/classes/alan/player\_class/features/FeatureAbstract.class](/target/classes/alan/player_class/features/FeatureAbstract.class) | Java | 4 | 0 | 0 | 4 |
| [target/classes/alan/player\_class/features/class\_features/LayOnHands.class](/target/classes/alan/player_class/features/class_features/LayOnHands.class) | Java | 49 | 0 | 0 | 49 |
| [target/classes/alan/player\_class/features/class\_features/MartialArts.class](/target/classes/alan/player_class/features/class_features/MartialArts.class) | Java | 53 | 2 | 0 | 55 |
| [target/classes/alan/player\_class/features/class\_features/SecondWind.class](/target/classes/alan/player_class/features/class_features/SecondWind.class) | Java | 36 | 5 | 0 | 41 |
| [target/classes/alan/player\_class/features/class\_features/UnarmoredDefense.class](/target/classes/alan/player_class/features/class_features/UnarmoredDefense.class) | Java | 2 | 0 | 0 | 2 |
| [target/classes/alan/player\_class/features/class\_features/WeaponMastery.class](/target/classes/alan/player_class/features/class_features/WeaponMastery.class) | Java | -7 | 0 | 0 | -7 |
| [target/classes/alan/player\_class/features/fighting\_style\_features/Defense.class](/target/classes/alan/player_class/features/fighting_style_features/Defense.class) | Java | -4 | 0 | 0 | -4 |
| [target/classes/alan/skills/ConditionEffect.class](/target/classes/alan/skills/ConditionEffect.class) | Java | -2 | 0 | 0 | -2 |
| [target/classes/alan/skills/Skill.class](/target/classes/alan/skills/Skill.class) | Java | -5 | 0 | 0 | -5 |
| [target/classes/alan/spells/SpellAbstract.class](/target/classes/alan/spells/SpellAbstract.class) | Java | 2 | 0 | 0 | 2 |
| [target/classes/alan/spells/level\_one/MageArmor.class](/target/classes/alan/spells/level_one/MageArmor.class) | Java | 2 | 0 | 0 | 2 |

[Summary](results.md) / [Details](details.md) / [Diff Summary](diff.md) / Diff Details