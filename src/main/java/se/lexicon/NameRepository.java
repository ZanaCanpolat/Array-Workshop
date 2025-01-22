package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: PART 1: implement getSize method

        if (names != null) {
            return names.length;
        }
        return 0;
    }

    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     * It is unclear to me where I should get the name to ad to the method, should I just invent a name or ask the user for input?
     *
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {
        //todo: PART 1: implement setNames method

        String[] newNames = new String[names.length + 1];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }
    }


    /**
     * Clears the names array by creating a new empty array.
     * I have problem with understanding the exercise / workshop, creating a new empty array does not clear the original
     * array and we have no way to access the newly created array of we dont return it, please explain what the meaning is
     */
    public static void clear() {
        //todo: PART 1: implement clear method

        /*Here is one way of clearing array
          names = new String[names.length];
         */

        /* Here is another way of clearing an array
        for (int i = 0; i < names.length; i++)
        {
            newNames[i] = null;
        }
         */

        /* Here is a third way of clearing an array we create a new array with same length but now way of using it
            String [] newNames = new String[names.length]
         */
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: PART 1: implement findAll method

        String[] newNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }
        return newNames;

        else
        {
            return null;
        }
    }

    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        //todo: PART 2: implement find method
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                return fullName;
            } else {
                return null;
            }
        }
    }

    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        //todo: PART 2: implement add method
        //Check the array, if name does not exist create a new array and add the name and return true.
        //If the name exists return false.

        if (find(fullName) == null) {
            String[] newName = new String[names.length + 1];
            for (int i = 0; i < names.length; i++) {
                newName[i] = names[i];
            }
            newName[newName.length - 1] = fullName;
            return true;
        } else {
            return false;
        }
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        //todo: PART 3: findByFirstName method
        //Read throw the array and check how many first names that matches in the array, create a new array with the
        //countsize, go throw the array again and ad all the name

        //This block of code iterates throw array and counts how many instance of lastname we find and ad to count
        int count = 0;
        String testName;
        for (int i = 0; i < names.length; i++) {
            testName = names[i].split(" ")[0];   //This line splits the name at the space and stores the first name in testname
            if (testName.equalsIgnoreCase(firstName))   //Compares the firstname with parameter without taking consideration to capital letters
            {
                count++;
            }
        }

        if (count != 0) {
            String[] newNames = new String[count];
            for (int i = 0; i < names.length; i++) {
                testName = names[i].split(" ")[0];   //This line splits the name at the space and stores the first name in testname
                if (testName.equalsIgnoreCase(firstName)) {
                    newNames[i] = names[i];
                }
            }
            return newNames;
        } else {
            return null;
        }
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        //todo: PART 3: implement findByLastName method

        //This block of code iterates throw array and counts how many instance of lastname we find and ad to count
        int count = 0;
        String testName;
        for (int i = 0; i < names.length; i++) {
            testName = names[i].split(" ")[1];   //This line splits the name at the space and stores the last name in testname
            if (testName.equalsIgnoreCase(lastName))   //Compares the lastname with parameter without taking consideration to capital letters
            {
                count++;
            }
        }

        if (count != 0) {
            String[] newNames = new String[count];
            for (int i = 0; i < names.length; i++) {
                testName = names[i].split(" ")[0];   //This line splits the name at the space and stores the first name in testname
                if (testName.equalsIgnoreCase(lastName)) {
                    newNames[i] = names[i];
                }
            }
            return newNames;
        } else {
            return null;
        }
    }

    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        //todo: PART 3: implement update method
        //Create a new array, iterate throw the array to find the name we need to update

        boolean updated = false;
        String [] newName = new String[names.length];

        for (int i = 0; i < names.length; i++)
        {
            if (names[i].equalsIgnoreCase(original))
            {
                newName[i] = updatedName;
                updated = true;

            }
            else
            {
                newName[i] = names[i];
            }
        }
        if (updated)
        {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        //todo: PART 4: implement remove method
        //Create an array that will hold the new list, iterate throw the list and contorl each element to fullName
        // If found set removed to true.

        boolean removed = false;

        String [] newName = new String[names.length];

        for (int i = 0; i < names.length; i++)
        {
            if (names[i].equalsIgnoreCase(fullName))
            {
                removed = true;
            }
            else
            {
                newName[i] = names[i];
            }
        }

        if(removed)
        {
            return true;
        }
        else {
            return false;
        }
    }


}