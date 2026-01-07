/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link TableContent#getTableName <em>Table Name</em>}</li>
 *   <li>{@link TableContent#getFrom <em>From</em>}</li>
 *   <li>{@link TableContent#getGiven <em>Given</em>}</li>
 *   <li>{@link TableContent#getUse <em>Use</em>}</li>
 *   <li>{@link TableContent#getWhere <em>Where</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getTableContent()
 * @model
 * @generated
 */
public interface TableContent extends EObject
{
  /**
   * Returns the value of the '<em><b>Table Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Table Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Table Name</em>' attribute.
   * @see #setTableName(String)
   * @see WreslEditorPackage#getTableContent_TableName()
   * @model
   * @generated
   */
  String getTableName();

  /**
   * Sets the value of the '{@link TableContent#getTableName <em>Table Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Table Name</em>' attribute.
   * @see #getTableName()
   * @generated
   */
  void setTableName(String value);

  /**
   * Returns the value of the '<em><b>From</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' attribute.
   * @see #setFrom(String)
   * @see WreslEditorPackage#getTableContent_From()
   * @model
   * @generated
   */
  String getFrom();

  /**
   * Sets the value of the '{@link TableContent#getFrom <em>From</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' attribute.
   * @see #getFrom()
   * @generated
   */
  void setFrom(String value);

  /**
   * Returns the value of the '<em><b>Given</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Given</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Given</em>' containment reference.
   * @see #setGiven(Assignment)
   * @see WreslEditorPackage#getTableContent_Given()
   * @model containment="true"
   * @generated
   */
  Assignment getGiven();

  /**
   * Sets the value of the '{@link TableContent#getGiven <em>Given</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Given</em>' containment reference.
   * @see #getGiven()
   * @generated
   */
  void setGiven(Assignment value);

  /**
   * Returns the value of the '<em><b>Use</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use</em>' attribute.
   * @see #setUse(String)
   * @see WreslEditorPackage#getTableContent_Use()
   * @model
   * @generated
   */
  String getUse();

  /**
   * Sets the value of the '{@link TableContent#getUse <em>Use</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use</em>' attribute.
   * @see #getUse()
   * @generated
   */
  void setUse(String value);

  /**
   * Returns the value of the '<em><b>Where</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Where</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Where</em>' containment reference.
   * @see #setWhere(WhereItems)
   * @see WreslEditorPackage#getTableContent_Where()
   * @model containment="true"
   * @generated
   */
  WhereItems getWhere();

  /**
   * Sets the value of the '{@link TableContent#getWhere <em>Where</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Where</em>' containment reference.
   * @see #getWhere()
   * @generated
   */
  void setWhere(WhereItems value);

} // TableContent
