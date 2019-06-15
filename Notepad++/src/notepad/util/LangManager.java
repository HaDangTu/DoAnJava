package notepad.util;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import java.io.File;

public class LangManager  extends Dictionary{

    private Hashtable<String, File> langAutoComplete;

    private static LangManager instance;

    public static LangManager getInstance(){
        if (instance == null) instance = new LangManager();
        return instance;
    }

    public LangManager(){
        langAutoComplete = new Hashtable<>();

        langAutoComplete.put(CategoryOfFile.C_FILE, new File("lang\\c.xml"));
        langAutoComplete.put(CategoryOfFile.HTML_FILE, new File("lang\\html.xml"));
        langAutoComplete.put(CategoryOfFile.JSP_FILE, new File("lang\\jsp.xml"));
        langAutoComplete.put(CategoryOfFile.PERL_FILE, new File("lang\\perl5.xml"));
        langAutoComplete.put(CategoryOfFile.PHP_FILE, new File("lang\\php.xml"));
        langAutoComplete.put(CategoryOfFile.LESS_FILE, new File("lang\\less_functions.xml"));
        langAutoComplete.put(CategoryOfFile.CPLUSPLUS_FILE, new File("lang\\cplusplus.xml"));
        langAutoComplete.put(CategoryOfFile.LUA_FILE, new File("lang\\lua.xml"));
    }

    /**
     * Returns the number of entries (distinct keys) in this dictionary.
     *
     * @return the number of keys in this dictionary.
     */
    @Override
    public int size() {
        return langAutoComplete.size();
    }

    /**
     * Tests if this dictionary maps no keys to value. The general contract
     * for the {@code isEmpty} method is that the result is true if and only
     * if this dictionary contains no entries.
     *
     * @return {@code true} if this dictionary maps no keys to values;
     * {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return langAutoComplete.isEmpty();
    }

    /**
     * Returns an enumeration of the keys in this dictionary. The general
     * contract for the keys method is that an {@code Enumeration} object
     * is returned that will generate all the keys for which this dictionary
     * contains entries.
     *
     * @return an enumeration of the keys in this dictionary.
     * @see Dictionary#elements()
     * @see Enumeration
     */
    @Override
    public Enumeration keys() {
        return langAutoComplete.keys();
    }

    /**
     * Returns an enumeration of the values in this dictionary. The general
     * contract for the {@code elements} method is that an
     * {@code Enumeration} is returned that will generate all the elements
     * contained in entries in this dictionary.
     *
     * @return an enumeration of the values in this dictionary.
     * @see Dictionary#keys()
     * @see Enumeration
     */
    @Override
    public Enumeration elements() {
        return langAutoComplete.elements();
    }

    /**
     * Returns the value to which the key is mapped in this dictionary.
     * The general contract for the {@code isEmpty} method is that if this
     * dictionary contains an entry for the specified key, the associated
     * value is returned; otherwise, {@code null} is returned.
     *
     * @param key a key in this dictionary.
     *            {@code null} if the key is not mapped to any value in
     *            this dictionary.
     * @return the value to which the key is mapped in this dictionary;
     * @throws NullPointerException if the {@code key} is {@code null}.
     * @see Dictionary#put(Object, Object)
     */
    @Override
    public File get(Object key) {
        return langAutoComplete.get(key);
    }

    /**
     * Maps the specified {@code key} to the specified
     * {@code value} in this dictionary. Neither the key nor the
     * value can be {@code null}.
     * <p>
     * If this dictionary already contains an entry for the specified
     * {@code key}, the value already in this dictionary for that
     * {@code key} is returned, after modifying the entry to contain the
     * new element. <p>If this dictionary does not already have an entry
     * for the specified {@code key}, an entry is created for the
     * specified {@code key} and {@code value}, and {@code null} is
     * returned.
     * <p>
     * The {@code value} can be retrieved by calling the
     * {@code get} method with a {@code key} that is equal to
     * the original {@code key}.
     *
     * @param key   the hashtable key.
     * @param value the value.
     * @return the previous value to which the {@code key} was mapped
     * in this dictionary, or {@code null} if the key did not
     * have a previous mapping.
     * @throws NullPointerException if the {@code key} or
     *                              {@code value} is {@code null}.
     * @see Object#equals(Object)
     * @see Dictionary#get(Object)
     */
    @Override
    public Object put(Object key, Object value) {
        return langAutoComplete.put((String) key, (File) value);
    }

    /**
     * Removes the {@code key} (and its corresponding
     * {@code value}) from this dictionary. This method does nothing
     * if the {@code key} is not in this dictionary.
     *
     * @param key the key that needs to be removed.
     * @return the value to which the {@code key} had been mapped in this
     * dictionary, or {@code null} if the key did not have a
     * mapping.
     * @throws NullPointerException if {@code key} is {@code null}.
     */
    @Override
    public Object remove(Object key) {
        return langAutoComplete.remove(key);
    }
}
