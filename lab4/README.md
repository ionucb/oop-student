### Documentația Proiectului Ecosistem

---

#### **1. Descrierea Claselor și Ierarhiilor**

**Ierarhia de clase:**
Diagrama UML oferă o structură ierarhică pentru entitățile ecosistemului. Aceasta include entități fundamentale pentru plante, animale (carnivore, erbivore, omnivore) și interacțiuni, organizate după funcționalitatea lor în cadrul simulării unui ecosistem.

- **EntitateEcosistem**: Clasa de bază pentru toate entitățile din ecosistem. Conține atributele comune pentru toate entitățile, cum ar fi numele, energia, rata de supraviețuire și locația (coordonatele x, y). Aceasta definește comportamentele de bază, precum verificarea vieții (`isAlive()`) și acțiunile (`act(Ecosystem ecosystem)`).
  
  - **Planta**: Reprezintă o plantă din ecosistem, cu metode precum `grow()` și `reproduce()`. Ea se adaugă și interacționează cu ecosistemul în mod specific.
  
  - **Animal**: Clasa de bază pentru toate animalele. Aceasta implementează comportamentele comune pentru animale, precum mișcarea, consumul de hrană (`eat(Ecosystem ecosystem)`) și reproducerea (`reproduce(Ecosystem ecosystem)`).
    - **Carnivor**: Clasa pentru carnivore, cu metode care definesc comportamentul de atac al altor animale (de exemplu, `ataca(Animal prey)`).
    - **Erbivor**: Clasa pentru erbivore, care se hrănesc cu plantele din ecosistem.
    - **Omnivor**: Clasa pentru omnivore, care pot mânca atât plante, cât și animale.

- **Ecosistem**: Clasa principală care conține toate entitățile din ecosistem. Se ocupă cu gestionarea entităților, oferind metode pentru adăugarea și eliminarea acestora, identificarea celor mai apropiate entități și simularea pas cu pas a evoluției ecosistemului.

- **EcosystemReport**: Clasa care generează rapoarte de activitate ale ecosistemului, cum ar fi populațiile și interacțiunile dintre entități.

- **Interactiune**: Interfață care definește metodele comune pentru atacuri și comportamente de reproducere între entități.

- **EcosystemSimulation**: Clasa care inițiază și rulează simularea ecosistemului, adăugând diverse entități și actualizând starea acestora pas cu pas.

---

#### **2. Explicația Fiecărei Metode**

- **EntitateEcosistem**
  - `getName()`: Returnează numele entității.
  - `isAlive()`: Verifică dacă entitatea este încă vie pe baza energiei și a ratei de supraviețuire.
  - `act(Ecosystem ecosystem)`: Metodă abstractă care este implementată de clasele derivate pentru a efectua acțiuni specifice, cum ar fi mișcare, hranire sau reproducere.

- **Planta**
  - `grow()`: Crește energia plantei.
  - `reproduce(Ecosystem ecosystem)`: Permite plantei să se reproducă dacă energia este suficientă, generând o nouă plantă în ecosistem.

- **Animal** (Clasă de bază)
  - `eat(Ecosystem ecosystem)`: Căută hrană (plante sau alte animale) și crește energia.
  - `move()`: Realizează mișcarea entității în ecosistem.
  - `reproduce(Ecosystem ecosystem)`: Permite reproducerea animalului dacă are suficientă energie.

- **Carnivor**
  - `ataca(Animal prey)`: Atacă o pradă și o consumă, crescându-și energia.

- **Erbivor**
  - `eat(Ecosystem ecosystem)`: Căută plante și le consumă pentru a-și crește energia.
  - `reproduce(Ecosystem ecosystem)`: Permite erbivorului să se reproducă, creând o nouă entitate.

- **Omnivor**
  - `eat(Ecosystem ecosystem)`: Căută plante sau animale și le consumă.
  - `reproduce(Ecosystem ecosystem)`: Permite omnivorului să se reproducă, adăugând o nouă entitate în ecosistem.

- **Ecosistem**
  - `addEntity(EntitateEcosistem entity)`: Adaugă o entitate în ecosistem.
  - `removeEntity(EntitateEcosistem entity)`: Elimină o entitate din ecosistem.
  - `findNearestPlant(int x, int y)`: Căută planta cea mai apropiată de coordonatele date.
  - `findNearestPrey(int x, int y)`: Căută prada (erbivor sau omnivor) cea mai apropiată de coordonatele date.
  - `simulateStep()`: Efectuează un pas al simulării, actualizând starea ecosistemului.

- **EcosystemReport**
  - `recordPopulation(String species, Long population)`: Înregistrează populația pentru o specie dată.
  - `generateReport()`: Generează și returnează raportul ecosistemului, incluzând populațiile și interacțiunile.

- **EcosystemSimulation**
  - `addHerbivore(Scanner scanner, Ecosystem ecosystem)`: Adaugă un erbivor în ecosistem.
  - `addCarnivore(Scanner scanner, Ecosystem ecosystem)`: Adaugă un carnivor în ecosistem.
  - `runSimulation(int steps)`: Rulează simularea ecosistemului pentru un număr de pași specificat.
  
- **Interactiune**
  - `ataca(Animal prey)`: Definirea comportamentului de atac între două entități (ex. carnivor atacă erbivor).
  - `reproduce(Ecosystem ecosystem)`: Definirea comportamentului de reproducere al entităților din ecosistem.

---

#### **3. UML Diagram**

Diagrama UML oferă o reprezentare vizuală detaliată a structurii și relațiilor dintre clasele proiectului. Aceasta include:

- **Clasele fundamentale**: `EntitateEcosistem`, `Animal`, `Planta`, `Carnivor`, `Erbivor`, `Omnivor`, `Ecosistem`, `EcosystemReport`, etc.
- **Metodele**: Fiecare clasă are metode specifice pentru acțiuni, mișcare, hrănire, atac și reproducere, iar unele metode sunt abstracte și sunt implementate de clasele derivate.
- **Interacțiuni între clase**: Clasa `Ecosystem` se ocupă cu gestionarea entităților, iar `EcosystemSimulation` rulează simularea, interacționând cu clasele din ecosistem.

---

#### **4. Scenarii de Utilizare**

**Scenariul 1: Crearea și simularea unui ecosistem cu carnivore și erbivore**
1. Se creează un ecosistem.
2. Se adaugă o plantă și un erbivor la coordonatele (0, 0).
3. Se adaugă un carnivor la coordonatele (1, 1).
4. Simularea începe:
   - Erbivorul mănâncă planta și își crește energia.
   - Carnivorul vânează erbivorul și își crește energia.
   - Erbivorul și carnivorul pot să se reproducă și să adauge noi entități.
5. După mai multe runde, raportul ecosistemului poate fi generat pentru a analiza populațiile.

**Scenariul 2: Simularea unei specii omnivore**
1. Se creează un ecosistem.
2. Se adaugă câteva plante și mai multe omnivore.
3. Omnivorele se hrănesc cu plantele și se reproduc.
4. Raportul populației va arăta creșterea speciei omnivore.

---

#### **5. Dificultăți Întâlnite și Soluții Adoptate**

1. **Gestionarea interacțiunilor complexe între specii**: Una dintre dificultățile majore a fost gestionarea corectă a interacțiunilor dintre carnivore, erbivore și plante. Soluția adoptată a fost crearea unei interfețe `Interactiune`, care definesc comportamentele comune ale atacurilor și reproducerii.
   
2. **Optimizarea simularii în ecosisteme mari**: La început, simulările lente au fost o problemă din cauza căutărilor repetate de plante și prăzi. Soluția a fost introducerea unor metode eficiente pentru localizarea entităților pe baza coordonatelor, reducând astfel complexitatea căutărilor.

3. **Verificarea vieții entităților**: Unele entități se putea comporta nerealist datorită lipsei unui mecanism corect de verificare a supraviețuirii. Am implementat un sistem de validare a energiei și ratei de supraviețuire pentru a asigura comportamentele naturale ale entităților.

---

Această documentație oferă o descriere detaliată a arhitecturii, comportamentului și funcționalităților proiectului, facilitând înțelegerea codului și a modului în care este gestionat ecosistemul virtual.