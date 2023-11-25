# ZOO Management System (Object-Oriented Program Design)

## Design Decisions

### 1. Animal Package
- **Contains:** Abstract class `Animal` and Classes for all 8 animals.
  - **a) Where:** All 8 classes (`Lion.java`, `Gazzele.java`, etc) inherit 2 methods from the `Animal` class: `getNickname` and `isCompatibleWith`.
  - **b) How:** The `getNickname` method is defined in the abstract Class `Animal` to not be an abstract method, so all the classes inheriting from `Animal` can make use of it. However, the `isCompatibleWith` method is defined to be abstract and is inherited into each of the 8 classes but is overridden by individual definitions.
  - **c) Why:** The `getNickname` method does the same thing for all classes, so it can easily be given a common definition in the `Animal` class for other classes to inherit and use. However, the `isCompatibleWith` method must be different for each inheriting class as each animal is compatible in a different way with another.

### 2. Area Package
- **Contains:** Interface class `IArea`, 2 other main classes, 5 other classes representing Areas in the zoo, and a helper class to store some data related to a given zoo instance (based on the `Zoo` class in the zoo package).
  - **a) Where:** The `AllAreaManager` and `LivingAreaManager` classes inherit from `IArea` and `AllAreaManager` respectively. Furthermore, `Entrance` and `PicnicArea` classes inherit from the `AllAreaManager` class, while `Enclosure`, `Cage`, and `Aquarium` inherit from `LivingAreaManager`.
  - **b) How:** `AllAreaManager` stores properties required by all 5 areas, whereas `LivingAreaManager` only stores the data and methods common to the 3 habitats, like implementation details of `AddAnimal`, how it is stored, etc.
  - **c) Why:** This design is followed as there are certain properties that all areas must have, while others are limited to only the habitat areas, thereby ensuring all 5 areas inherit only required properties. This helps reduce code duplication, implement abstraction, and data hiding.

### 3. Zoo Package
- **Consists of:** Mainly a final class `Codes`, an interface class `IZoo`, and a class called `Zoo` inheriting from `IZoo`.
  - **a) Where:** Class `Zoo` Inherits from `IZoo`, overrides all its methods, and makes use of the methods from the `StoreArea` class defined in the Area package.
  - **b) How:** `Zoo` defines an instance of `StoreArea` to access its methods and data.
  - **c) Why:** `Zoo` majorly calls methods from `StoreArea` and implements them as the “Controller” or logical block. `Store Area` was made mainly to act as the Model in MVC from the MVC design pattern, thereby making debugging easier and helping implement abstraction.

## Basic – Issues Encountered

## Intermediate – Modelling the Zoo’s Areas and Connections

- Utilized a `HashMap` to store the zoo’s areas as key-value pairs of unique integer ids and instances of the 5 area classes.
- Implemented methods to add, remove, and return key-value pairs from the `HashMap`, stored in another class called `StoreArea` in the Area package.
- Connected various areas of the Zoo using an ArrayList of integers to store the ids of the connected areas.
- Implemented `connectAreas` method to connect different areas by retrieving the area corresponding to the `fromAreaId` parameter and adding `toAreaId` to the ArrayList storing adjacent areas.
- The `IsPathAllowed` function was implemented to check the validity of a potential path for the visitor by looping through the set of given AreaIds.
- The `visit` method was implemented to return an ArrayList of the animals visited based on the areaIds of each area being visited.

## Intermediate – Alternative Model

- Another method of storing unique areaIds and their corresponding area instances is by using 2 ArrayLists, one for areaIds and another for area instances, connected by their indices.
- Issues with this approach include inefficient and lengthy code, increased chances of errors, and more exception cases to handle.
- Utilized `HashMap` for more efficient data structure and simpler getters and setters.

## Intermediate – Issues Encountered

- Issues with `findUnreachableAreas` method in the `Zoo` class.
- Initial implementation of depth first search led to complex issues and unexpected errors.
-
