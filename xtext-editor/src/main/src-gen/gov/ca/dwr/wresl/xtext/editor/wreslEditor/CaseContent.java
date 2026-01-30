/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CaseContent#getCaseName <em>Case Name</em>}</li>
 *   <li>{@link CaseContent#getCondition <em>Condition</em>}</li>
 *   <li>{@link CaseContent#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getCaseContent()
 * @model
 * @generated
 */
public interface CaseContent extends EObject
{
  /**
   * Returns the value of the '<em><b>Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Case Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Case Name</em>' attribute.
   * @see #setCaseName(String)
   * @see WreslEditorPackage#getCaseContent_CaseName()
   * @model
   * @generated
   */
  String getCaseName();

  /**
   * Sets the value of the '{@link CaseContent#getCaseName <em>Case Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Case Name</em>' attribute.
   * @see #getCaseName()
   * @generated
   */
  void setCaseName(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Condition)
   * @see WreslEditorPackage#getCaseContent_Condition()
   * @model containment="true"
   * @generated
   */
  Condition getCondition();

  /**
   * Sets the value of the '{@link CaseContent#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Condition value);

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(EObject)
   * @see WreslEditorPackage#getCaseContent_Content()
   * @model containment="true"
   * @generated
   */
  EObject getContent();

  /**
   * Sets the value of the '{@link CaseContent#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(EObject value);

} // CaseContent
