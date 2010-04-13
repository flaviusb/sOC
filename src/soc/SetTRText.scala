package soc;

import _root_.org.eclipse.jface._
import _root_.org.eclipse.swt._
import org.eclipse.jface.action._
import org.eclipse.swt.custom._
import org.eclipse.swt.graphics._
import org.eclipse.swt.layout._
import org.eclipse.swt.widgets._
import org.eclipse.jface.window._
import org.eclipse.jface.viewers._
import org.eclipse.jface.dialogs._
import scala.collection.mutable.{Map => MMap}

import org.eclipse.ui.IWorkbenchActionConstants
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

trait SetTRText {
  def setTRText(toSet: {def setText(text: String): Unit}, text: String): Unit = {
    toSet.setText(TranslationData.translations(text)(TranslationData.currlang))
  }
  def setTRTextCB(toSet: {def setText(text: String): Unit}, text: String): Unit = {
    if (TranslationData.translations.contains(text)) { 
      setTRText(toSet, text)
      TranslationData.translateCallback((y: String) => {toSet.setText(TranslationData.translations(text)(y)); null })
    } else {
      toSet.setText(text)
    }
  }
  def setTRTextCB(toSet: MenuManager, text: String): Unit = {
    TranslationData.translateCallback((y: String) => {toSet.getMenu().getParentItem().setText(TranslationData.translations(text)(y)); null })
  }
  def safeGetText(text: String, lang: String): String = {
    if (TranslationData.translations.contains(text))
      TranslationData.translations(text)(TranslationData.currlang)
    else
      text
  }
}

