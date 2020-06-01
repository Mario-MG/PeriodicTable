
package periodic_table;

import java.util.ArrayList;

/**
 *
 * @author Mario
 */
public enum Element {
    H(1, "Hydrogen", 1, 1, "Reactive nonmetal", "1.008", "Greek elements hydro- and -gen, meaning 'water-forming'"),
    HE(2, "Helium", 18, 1, "Noble gas", "40.026", "Greek helios, 'sun'"),
    LI(3, "Lithium", 1, 2, "Alkali metal", "6.94", "Greek l�thos, 'stone'"),
    BE(4, "Beryllium", 2, 2, "Alkaline earth metal", "90.122", "Beryl, a mineral (ultimately from the name of Belur in southern India)"),
    B(5, "Boron", 13, 2, "Metalloid", "10.81", "Borax, a mineral (from Arabic bawraq)"),
    C(6, "Carbon", 14, 2, "Reactive nonmetal", "12.011", "Latin carbo, 'coal'"),
    N(7, "Nitrogen", 15, 2, "Reactive nonmetal", "14.007", "Greek n�tron and -gen, meaning 'niter-forming'"),
    O(8, "Oxygen", 16, 2, "Reactive nonmetal", "15.999", "Greek oxy- and -gen, meaning 'acid-forming'"),
    F(9, "Fluorine", 17, 2, "Reactive nonmetal", "18.998", "Latin fluere, 'to flow'"),
    NE(10, "Neon", 18, 2, "Noble gas", "20.180", "Greek n�on, 'new'"),
    NA(11, "Sodium", 1, 3, "Alkali metal", "22.990", "English soda; the symbol Na is derived from New Latin natrium, coined from German Natron, 'natron'"),
    MG(12, "Magnesium", 2, 3, "Alkaline earth metal", "24.305", "Magnesia, a district of Eastern Thessaly in Greece"),
    AL(13, "Aluminium", 13, 3, "Post-transition metal", "26.982", "alumina, from Latin alumen (gen. aluminis), 'bitter salt, alum'"),
    SI(14, "Silicon", 14, 3, "Metalloid", "28.085", "Latin silex, 'flint' (originally silicium)"),
    P(15, "Phosphorus", 15, 3, "Reactive nonmetal", "30.974", "Greek phosph�ros, 'light-bearing'"),
    S(16, "Sulfur", 16, 3, "Reactive nonmetal", "32.06", "Latin sulphur, 'brimstone'"),
    CL(17, "Chlorine", 17, 3, "Reactive nonmetal", "35.45", "Greek chlor�s, 'greenish yellow'"),
    AR(18, "Argon", 18, 3, "Noble gas", "39.95", "Greek arg�s, 'idle' (because of its inertness)"),
    K(19, "Potassium", 1, 4, "Alkali metal", "39.098", "New Latin potassa, 'potash'; the symbol K is derived from Latin kalium"),
    CA(20, "Calcium", 2, 4, "Alkaline earth metal", "40.078", "Latin calx, 'lime'"),
    SC(21, "Scandium", 3, 4, "Transition metal", "44.956", "Latin Scandia, 'Scandinavia'"),
    TI(22, "Titanium", 4, 4, "Transition metal", "47.867", "Titans, the sons of the Earth goddess of Greek mythology"),
    V(23, "Vanadium", 5, 4, "Transition metal", "50.942", "Vanadis, an Old Norse name for the Scandinavian goddess Freyja"),
    CR(24, "Chromium", 6, 4, "Transition metal", "51.996", "Greek chr�ma, 'colour'"),
    MN(25, "Manganese", 7, 4, "Transition metal", "54.938", "Corrupted from magnesia negra; see Magnesium"),
    FE(26, "Iron", 8, 4, "Transition metal", "55.845", "English word; the symbol Fe is derived from Latin ferrum"),
    CO(27, "Cobalt", 9, 4, "Transition metal", "58.933", "German Kobold, 'goblin'"),
    NI(28, "Nickel", 10, 4, "Transition metal", "58.693", "Nickel, a mischievous sprite of German miner mythology"),
    CU(29, "Copper", 11, 4, "Transition metal", "63.546", "English word, from Latin cuprum, from Ancient Greek K�pros 'Cyprus'"),
    ZN(30, "Zinc", 12, 4, "Post-transition metal", "65.38", "Most likely from German Zinke, 'prong' or 'tooth', though some suggest Persian sang, 'stone'"),
    GA(31, "Gallium", 13, 4, "Post-transition metal", "69.723", "Latin Gallia, 'France'"),
    GE(32, "Germanium", 14, 4, "Metalloid", "72.630", "Latin Germania, 'Germany'"),
    AS(33, "Arsenic", 15, 4, "Metalloid", "74.922", "French arsenic, from Greek arsenik�n 'yellow arsenic' (influenced by arsenik�s, 'masculine' or 'virile'), from a West Asian wanderword ultimately from Old Iranian *zarniya-ka, 'golden'"),
    SE(34, "Selenium", 16, 4, "Reactive nonmetal", "78.971", "Greek selene, 'moon'"),
    BR(35, "Bromine", 17, 4, "Reactive nonmetal", "79.904", "Greek br�mos, 'stench'"),
    KR(36, "Krypton", 18, 4, "Noble gas", "83.798", "Greek krypt�s, 'hidden'"),
    RB(37, "Rubidium", 1, 5, "Alkali metal", "85.468", "Latin rubidus, 'deep red'"),
    SR(38, "Strontium", 2, 5, "Alkaline earth metal", "87.62", "Strontian, a village in Scotland"),
    Y(39, "Yttrium", 3, 5, "Transition metal", "88.906", "Ytterby, a village in Sweden"),
    ZR(40, "Zirconium", 4, 5, "Transition metal", "91.224", "Zircon, a mineral"),
    NB(41, "Niobium", 5, 5, "Transition metal", "92.906", "Niobe, daughter of king Tantalus from Greek mythology"),
    MO(42, "Molybdenum", 6, 5, "Transition metal", "95.95", "Greek mol�bdaina, 'piece of lead', from m�lybdos, 'lead', due to confusuion with lead ore galena (PbS)"),
    TC(43, "Technetium", 7, 5, "Transition metal", "[97]", "Greek tekhnet�s, 'artificial'"),
    RU(44, "Ruthenium", 8, 5, "Transition metal", "101.07", "New Latin Ruthenia, 'Russia'"),
    RH(45, "Rhodium", 9, 5, "Transition metal", "102.91", "Greek rhod�eis, 'rose-coloured', from rh�don, 'rose'"),
    PD(46, "Palladium", 10, 5, "Transition metal", "106.42", "Asteroid Pallas, considered a planet at the time"),
    AG(47, "Silver", 11, 5, "Transition metal", "107.87", "English word; the symbol Ag is derived from Latin argentum"),
    CD(48, "Cadmium", 12, 5, "Post-transition metal", "112.41", "New Latin cadmia, from King Kadmos"),
    IN(49, "Indium", 13, 5, "Post-transition metal", "114.82", "Latin indicum, 'indigo' (colour found in its spectrum)"),
    SN(50, "Tin", 14, 5, "Post-transition metal", "118.71", "English word; the symbol Sn is derived from Latin stannum"),
    SB(51, "Antimony", 15, 5, "Metalloid", "121.76", "Latin antimonium, the origin of which is uncertain: folk etymologies suggest it is derived from Greek ant� ('against') + m�nos ('alone'), or Old French anti-moine, 'Monk's bane', but it could plausibly be from or related to Arabic itmid, 'antimony', reformatted as a Latin word; the symbol Sb is derived from Latin stibium 'stibnite'"),
    TE(52, "Tellurium", 16, 5, "Metalloid", "127.60", "Latin tellus, 'the ground, earth'"),
    I(53, "Iodine", 17, 5, "Reactive nonmetal", "126.90", "French iode, from Greek ioeides, 'violet')"),
    XE(54, "Xenon", 18, 5, "Noble gas", "131.29", "Greek x�non, neuter form of x�nos 'strange'"),
    CS(55, "Caesium", 1, 6, "Alkali metal", "132.91", "Latin caesius, 'sky-blue'"),
    BA(56, "Barium", 2, 6, "Alkaline earth metal", "137.33", "Greek bar�s, 'heavy'"),
    LA(57, "Lanthanum", 3, 6, "Lanthanide", "138.91", "Greek lanth�nein, 'to lie hidden'"),
    CE(58, "Cerium", 0, 6, "Lanthanide", "140.12", "The dwarf planet Ceres, considered a planet at the time"),
    PR(59, "Praseodymium", 0, 6, "Lanthanide", "140.91", "Greek pr�sios d�dymos, 'green twin'"),
    ND(60, "Neodymium", 0, 6, "Lanthanide", "144.24", "Greek n�os d�dymos, 'new twin'"),
    PM(61, "Promethium", 0, 6, "Lanthanide", "[145]", "Prometheus of Greek mythology"),
    SM(62, "Samarium", 0, 6, "Lanthanide", "150.36", "Samarskite, a mineral named after Colonel Vasili Samarsky-Bykhovets, Russian mine official"),
    EU(63, "Europium", 0, 6, "Lanthanide", "151.96", "Europe"),
    GD(64, "Gadolinium", 0, 6, "Lanthanide", "157.25", "Gadolinite, a mineral named after Johan Gadolin, Finnish chemist, physicist and mineralogist"),
    TB(65, "Terbium", 0, 6, "Lanthanide", "158.93", "Ytterby, a village in Sweden"),
    DY(66, "Dysprosium", 0, 6, "Lanthanide", "162.50", "Greek dyspr�sitos, 'hard to get'"),
    HO(67, "Holmium", 0, 6, "Lanthanide", "164.93", "New Latin Holmia, 'Stockholm'"),
    ER(68, "Erbium", 0, 6, "Lanthanide", "167.26", "Ytterby, a village in Sweden"),
    TM(69, "Thulium", 0, 6, "Lanthanide", "168.93", "Thule, the ancient name for an unclear northern location"),
    YB(70, "Ytterbium", 0, 6, "Lanthanide", "173.05", "Ytterby, a village in Sweden"),
    LU(71, "Lutetium", 0, 6, "Lanthanide", "174.97", "Latin Lutetia, 'Paris'"),
    HF(72, "Hafnium", 4, 6, "Transition metal", "178.49", "New Latin Hafnia, 'Copenhagen' (from Danish havn)"),
    TA(73, "Tantalum", 5, 6, "Transition metal", "180.95", "King Tantalus, father of Niobe from Greek mythology"),
    W(74, "Tungsten", 6, 6, "Transition metal", "183.84", "Swedish tung sten, 'heavy stone' (The symbol W is from Wolfram, a name used for the element in many languages, originally from Middle High German wolf-rahm (wolf's foam) describing the mineral wolframite)[3]"),
    RE(75, "Rhenium", 7, 6, "Transition metal", "186.21", "Latin Rhenus, 'the Rhine'"),
    OS(76, "Osmium", 8, 6, "Transition metal", "190.23", "Greek osme, 'smell'"),
    IR(77, "Iridium", 9, 6, "Transition metal", "192.22", "Iris, the Greek goddess of the rainbow"),
    PT(78, "Platinum", 10, 6, "Transition metal", "195.08", "Spanish platina, 'little silver', from plata 'silver'"),
    AU(79, "Gold", 11, 6, "Transition metal", "196.97", "English word; the symbol Au is derived from Latin aurum"),
    HG(80, "Mercury", 12, 6, "Post-transition metal", "200.59", "Mercury, Roman god of commerce, communication, and luck, known for his speed and mobility; the symbol Hg is derived from the Latin name hydrargyrum, from Greek hydr�rgyros, 'water-silver'"),
    TL(81, "Thallium", 13, 6, "Post-transition metal", "204.38", "Greek thall�s, 'green shoot or twig'"),
    PB(82, "Lead", 14, 6, "Post-transition metal", "207.2", "English word; the symbol Pb is derived from Latin plumbum"),
    BI(83, "Bismuth", 15, 6, "Post-transition metal", "208.98", "German Wismut, from wei� Masse 'white mass', unless from Arabic"),
    PO(84, "Polonium", 16, 6, "Post-transition metal", "[209]", "Latin Polonia, 'Poland' (the home country of Marie Curie)"),
    AT(85, "Astatine", 17, 6, "Metalloid", "[210]", "Greek �statos, 'unstable'"),
    RN(86, "Radon", 18, 6, "Noble gas", "[222]", "Radium emanation, originally the name of the isotope Radon-222"),
    FR(87, "Francium", 1, 7, "Alkali metal", "[223]", "France"),
    RA(88, "Radium", 2, 7, "Alkaline earth metal", "[226]", "French radium, from Latin radius, 'ray'"),
    AC(89, "Actinium", 3, 7, "Actinide", "[227]", "Greek akt�s, 'ray'"),
    TH(90, "Thorium", 0, 7, "Actinide", "232.04", "Thor, the Scandinavian god of thunder"),
    PA(91, "Protactinium", 0, 7, "Actinide", "231.04", "Proto- (from Greek pr�tos, 'first, before') + actinium, which is produced through the radioactive decay of protactinium"),
    U(92, "Uranium", 0, 7, "Actinide", "238.03", "Uranus, the seventh planet in the Solar System"),
    NP(93, "Neptunium", 0, 7, "Actinide", "[237]", "Neptune, the eighth planet in the Solar System"),
    PU(94, "Plutonium", 0, 7, "Actinide", "[244]", "the dwarf planet Pluto, considered the ninth planet in the Solar System at the time"),
    AM(95, "Americium", 0, 7, "Actinide", "[243]", "The Americas, as the element was first synthesised on the continent, by analogy with europium"),
    CM(96, "Curium", 0, 7, "Actinide", "[247]", "Pierre Curie and Marie Curie, French physicists and chemists"),
    BK(97, "Berkelium", 0, 7, "Actinide", "[247]", "Berkeley, California, where the element was first synthesised, by analogy with terbium"),
    CF(98, "Californium", 0, 7, "Actinide", "[251]", "California, where the element was first synthesised"),
    ES(99, "Einsteinium", 0, 7, "Actinide", "[252]", "Albert Einstein, German physicist"),
    FM(100, "Fermium", 0, 7, "Actinide", "[257]", "Enrico Fermi, Italian physicist"),
    MD(101, "Mendelevium", 0, 7, "Actinide", "[258]", "Dmitri Mendeleev, Russian chemist and inventor who proposed the periodic table"),
    NO(102, "Nobelium", 0, 7, "Actinide", "[259]", "Alfred Nobel, Swedish chemist and engineer"),
    LR(103, "Lawrencium", 0, 7, "Actinide", "[266]", "Ernest Lawrence, American physicist"),
    RF(104, "Rutherfordium", 4, 7, "Transition metal", "[267]", "Ernest Rutherford, chemist and physicist from New Zealand"),
    DB(105, "Dubnium", 5, 7, "Transition metal", "[268]", "Dubna, Russia, where the Joint Institute for Nuclear Research is located"),
    SG(106, "Seaborgium", 6, 7, "Transition metal", "[269]", "Glenn T. Seaborg, American chemist"),
    BH(107, "Bohrium", 7, 7, "Transition metal", "[270]", "Niels Bohr, Danish physicist"),
    HS(108, "Hassium", 8, 7, "Transition metal", "[269]", "New Latin Hassia, 'Hesse' (a state in Germany)"),
    MT(109, "Meitnerium", 9, 7, "Unknown chemical properties", "[278]", "Lise Meitner, Austrian physicist"),
    DS(110, "Darmstadtium", 10, 7, "Unknown chemical properties", "[281]", "Darmstadt, Germany, where the element was first synthesised"),
    RG(111, "Roentgenium", 11, 7, "Unknown chemical properties", "[282]", "Wilhelm Conrad R�ntgen, German physicist"),
    CN(112, "Copernicium", 12, 7, "Post-transition metal", "[285]", "Nicolaus Copernicus, Polish astronomer"),
    NH(113, "Nihonium", 13, 7, "Unknown chemical properties", "[286]", "Japanese Nihon, 'Japan' (where the element was first synthesised)"),
    FL(114, "Flerovium", 14, 7, "Unknown chemical properties", "[289]", "Flerov Laboratory of Nuclear Reactions, part of JINR, where the element was synthesised; itself named after Georgy Flyorov, Russian physicist"),
    MC(115, "Moscovium", 15, 7, "Unknown chemical properties", "[290]", "Moscow Oblast, Russia, where the element was first synthesised"),
    LV(116, "Livermorium", 16, 7, "Unknown chemical properties", "[293]", "Lawrence Livermore National Laboratory in Livermore, California, which collaborated with JINR on its synthesis"),
    TS(117, "Tennessine", 17, 7, "Unknown chemical properties", "[294]", "Tennessee, United States (where Oak Ridge National Laboratory is located)"),
    OG(118, "Oganesson", 18, 7, "Unknown chemical properties", "[294]", "Yuri Oganessian, Russian physicist") ;
    
    
    public final int Z, group, period ;
    public final String symbol, name, type, weight, etymology ;
    private static ArrayList<Element> elementList = new ArrayList() ;

    private Element(int Z, String name, int group, int period, String type, String weight, String etymology ) {
        this.symbol = Character.toString(this.name().charAt(0)).toUpperCase() + this.name().substring(1).toLowerCase() ;
        this.Z = Z ;
        this.name = name ;
        this.group = group ;
        this.period = period ;
        this.type = type ;
        this.weight = weight ;
        this.etymology = etymology ;
    }
    
    public double getWeight() {
        double w = 0.0 ;
        try {
            w = Double.parseDouble(weight) ;
        } catch ( NumberFormatException ex ) {
            w = Double.parseDouble(weight.replaceAll("\\[|\\]", "")) ;
            System.out.println("Careful, you're about to use an estimated weight.");
        }
        return w ;
    }
    

}
