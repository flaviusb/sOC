package soc;

import scala.collection.mutable.{Map => MMap}

object TranslationData {
  implicit def tup2map(a: (String, Seq[(String, String)])*) : MMap[String, MMap[String, String]] = {
    var res = MMap[String, MMap[String, String]]()
    for(index <- a.elements) res = res ++ MMap(index._1 -> MMap(index._2: _*))
    res
  }
  var translations : MMap[String, MMap[String, String]] = 
    tup2map(
 ("OpenCell" -> Seq(("en" -> "OpenCell"), ("fr" -> ""))),                                                                                                             
 ("Help" -> Seq(("en" -> "Help"), ("fr" -> "?"))),                                                                                                                    
 ("Tools" -> Seq(("en" -> "Tools"), ("fr" -> "Outils"))),                                                                                                             
 ("Language" -> Seq(("en" -> "Language"), ("fr" -> "Langage"))),                                                                                                      
 ("File" -> Seq(("en" -> "&File"), ("fr" -> "&Fichier"))),                                                                                                              
 ("New" -> Seq(("en" -> "New"), ("fr" -> "Nouveau"))),                                                                                                                
 ("Export To" -> Seq(("en" -> "Export To"), ("fr" -> "Exporter Vers"))),                                                                                              
 ("Edit" -> Seq(("en" -> "&Edit"), ("fr" -> "&Editer"))),                                                                                                               
 ("View" -> Seq(("en" -> "View"), ("fr" -> "Voir"))),                                                                                                                 
 ("Toolbars" -> Seq(("en" -> "Toolbars"), ("fr" -> "Barres d"))),                                                                                                     
 ("Run" -> Seq(("en" -> "Run"), ("fr" -> "Exécuter"))),                                                                                                               
 ("Session" -> Seq(("en" -> "Session"), ("fr" -> "Session"))),                                                                                                        
 ("Look up the OpenCell help" -> Seq(("en" -> "Look up the OpenCell help"), ("fr" -> "Consulter l"))),                                                                
 ("F1" -> Seq(("en" -> "F1"), ("fr" -> ""))),                                                                                                                         
 ("How To..." -> Seq(("en" -> "How To..."), ("fr" -> "Comment Faire..."))),                                                                                           
 ("How To" -> Seq(("en" -> "How To"), ("fr" -> "Comment Faire"))),                                                                                                    
 ("Look up how to do things in OpenCell" -> Seq(("en" -> "Look up how to do things in OpenCell"), ("fr" -> "Consulter comment faire certaines choses avec OpenCell"))),                                                                                                                                                                     
 ("FAQ" -> Seq(("en" -> "FAQ"), ("fr" -> ""))),                                                                                                                       
 ("FAQ" -> Seq(("en" -> "FAQ"), ("fr" -> ""))),                                                                                                                       
 ("Look up the OpenCell FAQ" -> Seq(("en" -> "Look up the OpenCell FAQ"), ("fr" -> "Consulter la FAQ d"))),                                                           
 ("Home Page" -> Seq(("en" -> "Home Page"), ("fr" -> "Page d"))),                                                                                                     
 ("Look up the OpenCell home page" -> Seq(("en" -> "Look up the OpenCell home page"), ("fr" -> "Consulter la page d"))),                                              
 ("Update" -> Seq(("en" -> "Update"), ("fr" -> "Mise à Jour"))),                                                                                                      
 ("Update OpenCell with the latest version available from the OpenCell website" -> Seq(("en" -> "Update OpenCell with the latest version available from the OpenCell website"), ("fr" -> "Remplacer OpenCell avec la dernière version disponible sur le site d"))),                                                                         
 ("About" -> Seq(("en" -> "About"), ("fr" -> "A Propos"))),                                                                                                           
 ("Some general information about OpenCell, CellML, third party components and the system" -> Seq(("en" -> "Some general information about OpenCell, CellML, third party components and the system"), ("fr" -> "Quelques informations générales sur OpenCell, CellML, des composants externes et le système"))),                            
 ("CellML Home Page" -> Seq(("en" -> "CellML Home Page"), ("fr" -> "Page d"))),                                                                                       
 ("Look up the CellML home page" -> Seq(("en" -> "Look up the CellML home page"), ("fr" -> "Consulter la page d"))),                                                  
 ("CellML Repository" -> Seq(("en" -> "CellML Repository"), ("fr" -> "Répertoire CellML"))),                                                                          
 ("Look up the CellML repository" -> Seq(("en" -> "Look up the CellML repository"), ("fr" -> "Consulter le répertoire CellML"))),                                     
 ("English" -> Seq(("en" -> "English"), ("fr" -> "Anglais"))),                                                                                                        
 ("Select English as the language used by OpenCell" -> Seq(("en" -> "Select English as the language used by OpenCell"), ("fr" -> "Sélectionner l"))),                 
 ("French" -> Seq(("en" -> "French"), ("fr" -> "Français"))),                                                                                                         
 ("Select French as the language used by OpenCell" -> Seq(("en" -> "Select French as the language used by OpenCell"), ("fr" -> "Sélectionner le français comme langue utilisée par OpenCell"))),                                                                                                                                            
 ("Exit" -> Seq(("en" -> "E&xit"), ("fr" -> "&Quitter"))),                                                                                                              
 ("E&xit" -> Seq(("en" -> "E&xit"), ("fr" -> "&Quitter"))),                                                                                                              
 ("Exit OpenCell" -> Seq(("en" -> "Exit OpenCell"), ("fr" -> "Quitter OpenCell"))),                                                                                   
 ("Ctrl+Q" -> Seq(("en" -> "Ctrl+Q"), ("fr" -> ""))),                                                                                                                 
 ("CellML 1.0 File" -> Seq(("en" -> "CellML 1.0 File"), ("fr" -> "Fichier CellML 1.0"))),                                                                             
 ("CellML 1.1 File" -> Seq(("en" -> "CellML 1.1 File"), ("fr" -> "Fichier CellML 1.1"))),                                                                             
 ("Open..." -> Seq(("en" -> "Open..."), ("fr" -> "Ouvrir..."))),                                                                                                      
 ("Ctrl+O" -> Seq(("en" -> "Ctrl+O"), ("fr" -> ""))),                                                                                                                 
 ("Duplicate" -> Seq(("en" -> "Duplicate"), ("fr" -> "Dupliquer"))),                                                                                                  
 ("Ctrl+D" -> Seq(("en" -> "Ctrl+D"), ("fr" -> ""))),                                                                                                                 
 ("Locked" -> Seq(("en" -> "Locked"), ("fr" -> "Verrouillé"))),                                                                                                       
 ("Ctrl+L" -> Seq(("en" -> "Ctrl+L"), ("fr" -> ""))),                                                                                                                 
 ("Save" -> Seq(("en" -> "&Save"), ("fr" -> "Enregistrer"))),                                                                                                          
 ("Ctrl+S" -> Seq(("en" -> "Ctrl+S"), ("fr" -> ""))),                                                                                                                 
 ("Save &As..." -> Seq(("en" -> "Save As..."), ("fr" -> "Sauvegarder Sous..."))),                                                                                      
 ("Save All" -> Seq(("en" -> "Save All"), ("fr" -> "Tout Sauvegarder"))),                                                                                             
 ("Save all the CellML files" -> Seq(("en" -> "Save all the CellML files"), ("fr" -> "Sauvegarder tous les fichiers CellML"))),                                       
 ("Ctrl+Shift+S" -> Seq(("en" -> "Ctrl+Shift+S"), ("fr" -> ""))),                                                                                                     
 ("Download..." -> Seq(("en" -> "Download..."), ("fr" -> "Télécharger..."))),                                                                                         
 ("Download a CellML file" -> Seq(("en" -> "Download a CellML file"), ("fr" -> "Télécharger un fichier CellML"))),                                                    
 ("Upload..." -> Seq(("en" -> "Upload..."), ("fr" -> "Transférer..."))),                                                                                              
 ("Close" -> Seq(("en" -> "Close"), ("fr" -> "Fermer"))),                                                                                                             
 ("Ctrl+W" -> Seq(("en" -> "Ctrl+W"), ("fr" -> ""))),                                                                                                                 
 ("Close All" -> Seq(("en" -> "Close All"), ("fr" -> "Tout Fermer"))),                                                                                                
 ("Close all the CellML files" -> Seq(("en" -> "Close all the CellML files"), ("fr" -> "Fermer tous les fichiers CellML"))),                                          
 ("Ctrl+Shift+W" -> Seq(("en" -> "Ctrl+Shift+W"), ("fr" -> ""))),                                                                                                     
 ("C..." -> Seq(("en" -> "C..."), ("fr" -> "C..."))),                                                                                                                     
 ("C++..." -> Seq(("en" -> "C++..."), ("fr" -> "C++..."))),                                                                                                                 
 ("Delphi for Win32..." -> Seq(("en" -> "Delphi for Win32..."), ("fr" -> "Delphi pour Win32..."))),                                                                   
 ("Fortran 77..." -> Seq(("en" -> "Fortran 77..."), ("fr" -> "Fortran 77..."))),                                                                                                   
 ("Java..." -> Seq(("en" -> "Java..."), ("fr" -> "Java..."))),                                                                                                               
 ("MATLAB..." -> Seq(("en" -> "MATLAB..."), ("fr" -> "MATLAB..."))),                                                                                                           
 ("Microsoft Word 2007/2010..." -> Seq(("en" -> "Microsoft Word 2007/2010..."), ("fr" -> ""))),                                                                       
 ("Pascal..." -> Seq(("en" -> "Pascal..."), ("fr" -> ""))),                                                                                                           
 ("TeX..." -> Seq(("en" -> "TeX..."), ("fr" -> ""))),                                                                                                                 
 ("F9" -> Seq(("en" -> "F9"), ("fr" -> ""))),                                                                                                                         
 ("Stop" -> Seq(("en" -> "Stop"), ("fr" -> "Arrêter"))),                                                                                                              
 ("Ctrl+F2" -> Seq(("en" -> "Ctrl+F2"), ("fr" -> ""))),                                                                                                               
 ("Import..." -> Seq(("en" -> "Import..."), ("fr" -> "Importer..."))),                                                                                                
 ("Import an OpenCell session" -> Seq(("en" -> "Import an OpenCell session"), ("fr" -> "Importer une session OpenCell"))),                                            
 ("Export..." -> Seq(("en" -> "Export..."), ("fr" -> "Exporter..."))),                                                                                                
 ("Check Validity" -> Seq(("en" -> "Check Validity"), ("fr" -> "Vérifier Validité"))),                                                                                
 ("Alt+V" -> Seq(("en" -> "Alt+V"), ("fr" -> ""))),                                                                                                                   
 ("Reformat" -> Seq(("en" -> "Reformat"), ("fr" -> "Reformatter"))),                                                                                                  
 ("Show/hide the File toolbar" -> Seq(("en" -> "Show/hide the File toolbar"), ("fr" -> "Montrer/cacher la barre d"))),                                                
 ("Show/hide the Edit toolbar" -> Seq(("en" -> "Show/hide the Edit toolbar"), ("fr" -> "Montrer/cacher la barre d"))),                                                
 ("Show/hide the Run toolbar" -> Seq(("en" -> "Show/hide the Run toolbar"), ("fr" -> "Montrer/cacher la barre d"))),                                                  
 ("Show/hide the Help toolbar" -> Seq(("en" -> "Show/hide the Help toolbar"), ("fr" -> "Montrer/cacher la barre d"))),                                                
 ("Reset All" -> Seq(("en" -> "Reset All"), ("fr" -> "Tout Réinitialiser"))),                                                                                         
 ("Reset all the user settings" -> Seq(("en" -> "Reset all the user settings"), ("fr" -> "Réinitialiser tous les paramètres utilisateurs"))),                         
 ("Create a CellML 1.0 file" -> Seq(("en" -> "Create a CellML 1.0 file"), ("fr" -> "Créer un fichier CellML 1.0"))),                                                  
 ("Mode" -> Seq(("en" -> "Mode"), ("fr" -> "Mode"))),                                                                                                                 
 ("Create a CellML 1.1 file" -> Seq(("en" -> "Create a CellML 1.1 file"), ("fr" -> "Créer un fichier CellML 1.1"))),                                                  
 ("Open a CellML file" -> Seq(("en" -> "Open a CellML file"), ("fr" -> "Ouvrir un fichier CellML"))),                                                                 
 ("Duplicate the CellML file" -> Seq(("en" -> "Duplicate the CellML file"), ("fr" -> "Dupliquer le fichier CellML"))),                                                
 ("Lock/unlock the CellML file" -> Seq(("en" -> "Lock/unlock the CellML file"), ("fr" -> "Verrouiller/déverrouiller le fichier CellML"))),                            
 ("Save the CellML file" -> Seq(("en" -> "Save the CellML file"), ("fr" -> "Enregistrer le fichier CellML"))),                                                        
 ("Save the CellML file under a different name" -> Seq(("en" -> "Save the CellML file under a different name"), ("fr" -> "Enregistrer le fichier CellML sous un autre nom"))),                                                                                                                                                              
 ("Upload the CellML file" -> Seq(("en" -> "Upload the CellML file"), ("fr" -> "Transférer le fichier CellML"))),                                                     
 ("Close the CellML file" -> Seq(("en" -> "Close the CellML file"), ("fr" -> "Fermer le fichier CellML"))),                                                           
 ("Export the CellML file to C" -> Seq(("en" -> "Export the CellML file to C"), ("fr" -> "Exporter le fichier CellML vers C"))),                                      
 ("Export the CellML file to C++" -> Seq(("en" -> "Export the CellML file to C++"), ("fr" -> "Exporter le fichier CellML vers C++"))),                                
 ("Export the CellML file to Delphi for Win32" -> Seq(("en" -> "Export the CellML file to Delphi for Win32"), ("fr" -> "Exporter le fichier CellML vers Delphi pour Win32"))),                                                                                                                                                              
 ("Export the CellML file to Fortran 77" -> Seq(("en" -> "Export the CellML file to Fortran 77"), ("fr" -> "Exporter le fichier CellML vers Fortran 77"))),           
 ("Export the CellML file to Java" -> Seq(("en" -> "Export the CellML file to Java"), ("fr" -> "Exporter le fichier CellML vers Java"))),                             
 ("Export the CellML file to MATLAB" -> Seq(("en" -> "Export the CellML file to MATLAB"), ("fr" -> "Exporter le fichier CellML vers MATLAB"))),                       
 ("Export the CellML file to Microsoft Word 2007/2010" -> Seq(("en" -> "Export the CellML file to Microsoft Word 2007/2010"), ("fr" -> "Exporter le fichier CellML vers Word 2007/2010"))),                                                                                                                                                 
 ("Export the CellML file to Pascal" -> Seq(("en" -> "Export the CellML file to Pascal"), ("fr" -> "Exporter le fichier CellML vers Pascal"))),                       
 ("Export the CellML file to TeX" -> Seq(("en" -> "Export the CellML file to TeX"), ("fr" -> "Exporter le fichier CellML vers TeX"))),                                
 ("Run the CellML file" -> Seq(("en" -> "Run the CellML file"), ("fr" -> "Exécuter le fichier CellML"))),                                                             
 ("Stop the CellML file" -> Seq(("en" -> "Stop the CellML file"), ("fr" -> "Arrêter le fichier CellML"))),                                                            
 ("Export the OpenCell session" -> Seq(("en" -> "Export the OpenCell session"), ("fr" -> "Exporter la session OpenCell"))),                                           
 ("Check the validity of the CellML file" -> Seq(("en" -> "Check the validity of the CellML file"), ("fr" -> "Vérifier la validité du fichier CellML"))),             
 ("Reformat the CellML file" -> Seq(("en" -> "Reformat the CellML file"), ("fr" -> "Reformatter le fichier CellML"))),                                                
 ("Alt+R" -> Seq(("en" -> "Alt+R"), ("fr" -> ""))),                                                                                                                   
 ("Options..." -> Seq(("en" -> "Options..."), ("fr" -> ""))),                                                                                                         
 ("Options for OpenCell" -> Seq(("en" -> "Options for OpenCell"), ("fr" -> "Options pour OpenCell"))),                                                                
 ("Repository Explorer" -> Seq(("en" -> "Repository Explorer"), ("fr" -> "Gestionnaire Répertoire"))),                                                                
 ("Show/hide the Repository Explorer panel" -> Seq(("en" -> "Show/hide the Repository Explorer panel"), ("fr" -> "Montrer/cacher le panneau Gestionnaire Répertoire"))),                                                                                                                                                                    
 ("File Explorer" -> Seq(("en" -> "File Explorer"), ("fr" -> "Gestionnaire Fichier"))),                                                                               
 ("Show/hide the File Explorer panel" -> Seq(("en" -> "Show/hide the File Explorer panel"), ("fr" -> "Montrer/cacher le panneau Gestionnaire Fichier"))),             
 ("Models" -> Seq(("en" -> "Models"), ("fr" -> "Modèles"))),                                                                                                          
 ("Show/hide the Models panel" -> Seq(("en" -> "Show/hide the Models panel"), ("fr" -> "Montrer/cacher le panneau Modèles"))),                                        
 ("Viewer" -> Seq(("en" -> "Viewer"), ("fr" -> "Visionneur"))),                                                                                                       
 ("Show/hide the Viewer panel" -> Seq(("en" -> "Show/hide the Viewer panel"), ("fr" -> "Montrer/cacher le panneau Visionneur"))),                                     
 ("Messages" -> Seq(("en" -> "Messages"), ("fr" -> ""))),                                                                                                             
 ("Show/hide the Messages panel" -> Seq(("en" -> "Show/hide the Messages panel"), ("fr" -> "Montrer/cacher le panneau Messages"))),                                   
 ("Simulation" -> Seq(("en" -> "Simulation"), ("fr" -> ""))),                                                                                                         
 ("Show/hide the Simulation panel" -> Seq(("en" -> "Show/hide the Simulation panel"), ("fr" -> "Montrer/cacher le panneau Simulation"))),                             
 ("Parameters" -> Seq(("en" -> "Parameters"), ("fr" -> "Paramètres"))),                                                                                               
 ("Show/hide the Parameters panel" -> Seq(("en" -> "Show/hide the Parameters panel"), ("fr" -> "Montrer/cacher le panneau Paramètres"))),                             
 ("Console" -> Seq(("en" -> "Console"), ("fr" -> ""))),                                                                                                               
 ("Show/hide the Console panel" -> Seq(("en" -> "Show/hide the Console panel"), ("fr" -> "Montrer/cacher le panneau Console"))),                                      
 ("Undo" -> Seq(("en" -> "Undo"), ("fr" -> "Défaire"))),                                                                                                              
 ("Undo the last action" -> Seq(("en" -> "Undo the last action"), ("fr" -> "Défaire la dernière action"))),                                                           
 ("Ctrl+Z" -> Seq(("en" -> "Ctrl+Z"), ("fr" -> ""))),                                                                                                                 
 ("Redo" -> Seq(("en" -> "Redo"), ("fr" -> "Refaire"))),                                                                                                              
 ("Ctrl+Shift+Z" -> Seq(("en" -> "Ctrl+Shift+Z"), ("fr" -> ""))),                                                                                                     
 ("Cut" -> Seq(("en" -> "Cut"), ("fr" -> "Couper"))),                                                                                                                 
 ("Cut the selected object" -> Seq(("en" -> "Cut the selected object"), ("fr" -> "Couper l"))),                                                                       
 ("Ctrl+X" -> Seq(("en" -> "Ctrl+X"), ("fr" -> ""))),                                                                                                                 
 ("Copy" -> Seq(("en" -> "Copy"), ("fr" -> "Copier"))),                                                                                                               
 ("Copy the selected object" -> Seq(("en" -> "Copy the selected object"), ("fr" -> "Copier l"))),                                                                     
 ("Ctrl+C" -> Seq(("en" -> "Ctrl+C"), ("fr" -> ""))),                                                                                                                 
 ("Paste" -> Seq(("en" -> "Paste"), ("fr" -> "Coller"))),                                                                                                             
 ("Paste the contents of the clipboard" -> Seq(("en" -> "Paste the contents of the clipboard"), ("fr" -> "Coller le contenu du presse-papier"))),                     
 ("Ctrl+V" -> Seq(("en" -> "Ctrl+V"), ("fr" -> ""))),                                                                                                                 
 ("Delete" -> Seq(("en" -> "Delete"), ("fr" -> "Supprimer"))),                                                                                                        
 ("Delete the selected object" -> Seq(("en" -> "Delete the selected object"), ("fr" -> "Supprimer l"))),                                                              
 ("Del" -> Seq(("en" -> "Del"), ("fr" -> "Supp"))),                                                                                                                   
 ("Find..." -> Seq(("en" -> "Find..."), ("fr" -> "Chercher..."))),                                                                                                    
 ("Search for a specific object" -> Seq(("en" -> "Search for a specific object"), ("fr" -> "Chercher un objet spécifique"))),
 ("Search for a specific object and replace it with another" -> Seq(("en" -> "Search for a specific object and replace it with another"), ("fr" -> "Chercher un objet spécifique et le remplacer par un autre"))),
 ("Japanese" -> Seq(("en" -> "Japanese"), ("fr" -> "Japonais"))),
 ("Select Japanese as the language used by OpenCell" -> Seq(("en" -> "Select Japanese as the language used by OpenCell"), ("fr" -> "Sélectionner le japonais comme langue utilisée par OpenCell"))),
 ("Layout" -> Seq(("en" -> "Layout"), ("fr" -> "Apparence"))),
 ("Show/hide the Layout toolbar" -> Seq(("en" -> "Show/hide the Layout toolbar"), ("fr" -> "Montrer/cacher la barre d"))),
 ("Editing" -> Seq(("en" -> "Editing"), ("fr" -> "Edition"))),
 ("Select the Editing mode" -> Seq(("en" -> "Select the Editing mode"), ("fr" -> "Sélectionner le mode Edition"))),
 ("Select the Simulation mode" -> Seq(("en" -> "Select the Simulation mode"), ("fr" -> "Sélectionner le mode Simulation"))),
 ("Analysis" -> Seq(("en" -> "Analysis"), ("fr" -> "Analyse"))),
 ("Select the Analysis mode" -> Seq(("en" -> "Select the Analysis mode"), ("fr" -> "Sélectionner le mode Analyse"))),
 ("XML" -> Seq(("en" -> "XML"), ("fr" -> ""))),
 ("Select the XML view" -> Seq(("en" -> "Select the XML view"), ("fr" -> "Sélectionner la vue XML"))),
 ("COR" -> Seq(("en" -> "COR"), ("fr" -> ""))),
 ("Select the COR view" -> Seq(("en" -> "Select the COR view"), ("fr" -> "Sélectionner la vue COR"))),
 ("Mathematical" -> Seq(("en" -> "Mathematical"), ("fr" -> "Mathématique"))),
 ("Select the Mathematical view" -> Seq(("en" -> "Select the Mathematical view"), ("fr" -> "Sélectionner la vue Mathématique"))),
 ("Graphical" -> Seq(("en" -> "Graphical"), ("fr" -> "Graphique"))),
 ("Select the Graphical view" -> Seq(("en" -> "Select the Graphical view"), ("fr" -> "Sélectionner la vue Graphique"))),
 ("Biological" -> Seq(("en" -> "Biological"), ("fr" -> "Biologique"))),
 ("Select the Biological view" -> Seq(("en" -> "Select the Biological view"), ("fr" -> "Sélectionner la vue Biologique"))),
 ("Metadata" -> Seq(("en" -> "Metadata"), ("fr" -> ""))),
 ("Select the Metadata view" -> Seq(("en" -> "Select the Metadata view"), ("fr" -> "Sélectionner la vue Metadata"))),
 ("Ctrl+F" -> Seq(("en" -> "Ctrl+F"), ("fr" -> ""))),
 ("Redo the last action" -> Seq(("en" -> "Redo the last action"), ("fr" -> "Refaire la dernière action"))),
 ("Find Next" -> Seq(("en" -> "Find Next"), ("fr" -> "Chercher Suivant"))),
 ("Search forwards for the same object" -> Seq(("en" -> "Search forwards for the same object"), ("fr" -> "Chercher en avant le même objet"))),
 ("F3" -> Seq(("en" -> "F3"), ("fr" -> ""))),
 ("Find Previous" -> Seq(("en" -> "Find Previous"), ("fr" -> "Chercher Précédent"))),
 ("Search backwards for the same object" -> Seq(("en" -> "Search backwards for the same object"), ("fr" -> "Chercher en arrière le même objet"))),
 ("Shift+F3" -> Seq(("en" -> "Shift+F3"), ("fr" -> ""))),
 ("Replace..." -> Seq(("en" -> "Replace..."), ("fr" -> "Remplacer..."))),
 ("Ctrl+R" -> Seq(("en" -> "Ctrl+R"), ("fr" -> ""))),
 ("Select All" -> Seq(("en" -> "Select All"), ("fr" -> "Tout Sélectionner"))),
 ("Select all the objects" -> Seq(("en" -> "Select all the objects"), ("fr" -> "Sélectionner tous les objets"))),
 ("Ctrl+A" -> Seq(("en" -> "Ctrl+A"), ("fr" -> ""))),
 ("Add-ons..." -> Seq(("en" -> "Add-ons..."), ("fr" -> ""))),
 ("Add-ons for OpenCell" -> Seq(("en" -> "Add-ons for OpenCell"), ("fr" -> "Add-ons pour OpenCell"))),
 (" has not yet been implemented..." -> Seq(("en" -> " has not yet been implemented..."), ("fr" -> " n"))),
 ("Open CellML file(s)" -> Seq(("en" -> "Open CellML file(s)"), ("fr" -> "Ouvrir fichier(s) CellML"))),
 ("CellML File (*.cellml)" -> Seq(("en" -> "CellML File (*.cellml)"), ("fr" -> "Fichier CellML (*.cellml)"))),
 ("Save CellML file" -> Seq(("en" -> "Save CellML file"), ("fr" -> "Enregistrer fichier CellML")))
 )      

  var currlang = "en"
  var calls: List[String => Unit] = List[String => Unit]()
  def translateCallback(call: String => Unit) = { calls = calls.:::(List(call)) }
  def callcallbacks = { for(call <- calls) call(currlang) }
}

