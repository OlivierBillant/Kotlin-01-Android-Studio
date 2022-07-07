# Kotlin-01-Android-Studio

Guide DataBinding
	
Pour commencer rendez-vous dans votre fichier build.gradle relatif au module en cours
	
Ajouter dans la balise android{}
	buildFeatures{
	    dataBinding true
	}
	- dans le bandeau en haut appuyez sur "Sync Now" pour synchroniser votre fichier
	- Dans tout les layouts où l'on souhaite un DataBinding, se placer dans la vue "Code" 
  et en se plaçant sur le ConstraintLayout parent avec le curseur, appuyer sur Alt+Entrée et "Convert to DataBinding Layout
	"VOIR ConvertToDataBindingLayout.png"
	
	
Il faut bien comprendre que la classe créée pour le databinding d'un layout porte le nom du fichier layout. Exemple: 
	

		
J'ai une activité qui s'appelle MainActivity, qui possède un layout appelé "activity_main.xml"  fichier databinding => ActivityMainBinding
	
	
	
 - Dans le contrôleur correspondant, on peut récupérer notre Binding comme ci-dessous dans un Fragment :
	
	
public class ListArticlesFragment extends Fragment {
    FragmentListArticlesBinding flab;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
Bundle savedInstanceState) {
        flab =  FragmentListArticlesBinding.inflate(inflater);
        return flab.getRoot();
}
}
	
	ou pour récupérer une instance de DataBinding dans une Activité
	
	
public class MainActivity extends AppCompatActivity { 
private ActivityMainBinding amb;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
amb = DataBindingUtil.setContentView(this,R.layout.activity_main);
}
}
	





Guide Navigation
    Lexique :
Navigation Graph : Fichier XML de type "navigation" permettant d'établire le flux de navigation entre tout les fragments
Navigation Controller : Contrôleur permettant de se déplacer entre les différents fragments du navigation graph par l'intermédiaire


Pour la navigation API, nous devons utiliser des fragments en tant que page. 
Pour créer un fragment :


	
Clic droit sur votre package dans java : clic droit -> New -> Fragment -> Fragment Blank
	
Nommez votre fragment
	
Répétez cette opération pour le nombre de pages souhaitées.

Ensuite, créer un Navigation Graph.


	
Clic droit sur res -> New -> Android Resource File
	
Sélectionnez le type de ressource "navigation"
	
Nommez votre fichier

Dans ce fichier ajoutez  vos fragment un à un avec

Vous allez ensuite pouvoir créer des "actions" (flèches) entre les "destinations" (vos fragments) 
juste en glissant déposant depuis le bord des fragments avec la petite bille bleue.

Ensuite, afficher votre navigation en ajoutant la vue NavHostFragment dans les fichier activity_main.xml. 
Sans cette étape, la navigation ne pourra pas être afficher à l'écran car, pas de possibilité de lancer un fragment sans activité.


Pour passer d'un fragment à un autre fragment, vous pouvez utiliser le Navigation Controller comme ceci :

	
Dans le fragment de votre choix (fragment source)
      
        Kotlin
    
val button = view.findViewById<Button>(R.id.buttonToTarget)
button.setOnClickListener {​
  Navigation.findNavController(view).navigate(R.id.action_buttonFragment_to_targetFragment)
}​
  
L'id de l'action est automatiquement généré depuis la flèche créée dans le Navigation Graph. 
Utliser l'action correspondante à votre situation : action_fragmentSource_to_fragmentDestination