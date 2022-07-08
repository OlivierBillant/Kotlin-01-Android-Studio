# Kotlin-01-Android-Studio

## Guide DataBinding

Pour commencer rendez-vous dans votre fichier build.gradle relatif au module en cours  
Ajouter dans la balise android{}
```kotlin
buildFeatures{
  dataBinding true
} 
```
- Dans le bandeau en haut appuyez sur **"Sync Now"** pour synchroniser votre fichier 
- Dans tout les layouts où l'on souhaite un DataBinding, se placer dans la vue "Code"  
et en se plaçant sur le ConstraintLayout parent avec le curseur,  
**appuyer sur Alt+Entrée** et **"Convert to DataBinding Layout**

Il faut bien comprendre que **la classe créée pour le databinding d'un layout porte le nom du fichier layout**. 

### Exemple:
J'ai une activité qui s'appelle MainActivity  
Elle possède un layout appelé 
> "activity_main.xml" fichier databinding => ActivityMainBinding

Dans le contrôleur correspondant, on peut **récupérer notre Binding** comme ci-dessous dans un Fragment :

```kotlin
public class ListArticlesFragment extends Fragment {
  FragmentListArticlesBinding flab;
  
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    flab = FragmentListArticlesBinding.inflate(inflater);
    return flab.getRoot();
  }
}
```

ou pour **récupérer une instance** de DataBinding dans une Activité

```kotlin
public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding amb;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    amb = DataBindingUtil.setContentView(this,R.layout.activity_main);
  }
}
```

## Guide Navigation

### Lexique :
> Navigation Graph : Fichier XML de type "navigation" permettant d'établire le flux de navigation entre tout les fragments  
Navigation Controller : Contrôleur permettant de se déplacer entre les différents fragments du navigation graph par l'intermédiaire

Pour la **navigation API**, nous devons utiliser des fragments en tant que page.  
1. Pour créer un fragment :
   - Clic droit sur votre package dans java : clic droit -> New -> Fragment -> Fragment Blank
   - Nommez votre fragment
   - Répétez cette opération pour le nombre de pages souhaitées.

2. Créer un Navigation Graph.
   - Clic droit sur res -> New -> Android Resource File
   - Sélectionnez le type de ressource "navigation"
   - Nommez votre fichier

3. Dans ce fichier ajoutez vos fragment un à un avec le **bouton Fragment+**

4. Créer des "actions" (flèches) entre les "destinations" (vos fragments)  
juste en glissant déposant depuis le bord des fragments avec la petite bille bleue.

5. Afficher votre navigation en ajoutant **la vue (container) NavHostFragment** dans les fichier activity_main.xml.  
Sans cette étape, la navigation ne pourra pas être afficher à l'écran car, pas de possibilité de lancer un fragment sans activité.

6. Pour passer d'un fragment à un autre fragment, vous pouvez utiliser le Navigation Controller comme ceci :
   - Dans le fragment de votre choix (fragment source)
   - L'id de l'action est automatiquement généré depuis la flèche créée dans le Navigation Graph.
   - Utliser l'action correspondante à votre situation : action_fragmentSource_to_fragmentDestination

```kotlin
val button = view.findViewById<Button>(R.id.buttonToTarget)

button.setOnClickListener {​
  Navigation.findNavController(view).navigate(R.id.action_buttonFragment_to_targetFragment)
}​
```

## Guide Sage Args
### Configuration
Dans le gradle parent on ajoute les éléments suivants provenant de :  
[https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args]

``` kotlin
buildscript {
    repositories {
        google()
    }
    dependencies {
        def nav_version = "2.5.0"
        classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
    }
}
```

Puis dans le gradle du module on ajoute dans plugin : 
```kotlin
plugins {
    id 'androidx.navigation.safeargs'
    id 'kotlin-parcelize'
}
```

Après avoir crée un binding avec les donénes à récupérer  
On prépare notre binding :  

```kotlin
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
```
Puis on crée un objet à partir de éléments bindés ad hoc :  
```kotlin
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val histoire = Histoire(
                binding.editTextPrenom.text.toString(),
                binding.editTextLieu.text.toString(),
            )
```
On construit l'action de changement de page à laquelle on passe l'argument (objet) nécessaire :
```kotlin
            var action = HomeFragmentDirections.actionHomeFragmentToTargetFragment(histoire)
            Navigation.findNavController(view)
                .navigate(action)
        }
    }
```

Sur la page cible on pourra alors récupérer le bundle d'argument passés et en extraire les objets :  
```kotlin
        val targetFragmentArgs = arguments?.let { TargetFragmentArgs.fromBundle(it) }
```
}

## Navigation externe
Composition d'un intent : 
- nom de l'action
- URI référencant les données
- nom du composant ) démarrer
- catégories du type de composant
- Extras : donénes à transporter
- Flag qui indique comment démarrer une activité.


``` kotlin
 val buttonMain = findViewById<Button>(R.id.buttonMain)
        buttonMain.setOnClickListener {
            val intentToTarget = Intent(this, TargetActivity::class.java)
            intentToTarget.putExtra("age", 34)
            startActivity(intentToTarget)
        }
```

### Les extras
Fonctionnent en clef valeur.

