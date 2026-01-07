/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lower And Or Upper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LowerAndOrUpper#getKind <em>Kind</em>}</li>
 *   <li>{@link LowerAndOrUpper#getUnits <em>Units</em>}</li>
 *   <li>{@link LowerAndOrUpper#getUpper <em>Upper</em>}</li>
 *   <li>{@link LowerAndOrUpper#getLower <em>Lower</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getLowerAndOrUpper()
 * @model
 * @generated
 */
public interface LowerAndOrUpper extends DVarIntegerNonStd
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see #setKind(String)
   * @see WreslEditorPackage#getLowerAndOrUpper_Kind()
   * @model
   * @generated
   */
  String getKind();

  /**
   * Sets the value of the '{@link LowerAndOrUpper#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see #getKind()
   * @generated
   */
  void setKind(String value);

  /**
   * Returns the value of the '<em><b>Units</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Units</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Units</em>' attribute.
   * @see #setUnits(String)
   * @see WreslEditorPackage#getLowerAndOrUpper_Units()
   * @model
   * @generated
   */
  String getUnits();

  /**
   * Sets the value of the '{@link LowerAndOrUpper#getUnits <em>Units</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Units</em>' attribute.
   * @see #getUnits()
   * @generated
   */
  void setUnits(String value);

  /**
   * Returns the value of the '<em><b>Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper</em>' containment reference.
   * @see #setUpper(Upper)
   * @see WreslEditorPackage#getLowerAndOrUpper_Upper()
   * @model containment="true"
   * @generated
   */
  Upper getUpper();

  /**
   * Sets the value of the '{@link LowerAndOrUpper#getUpper <em>Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper</em>' containment reference.
   * @see #getUpper()
   * @generated
   */
  void setUpper(Upper value);

  /**
   * Returns the value of the '<em><b>Lower</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower</em>' containment reference.
   * @see #setLower(Lower)
   * @see WreslEditorPackage#getLowerAndOrUpper_Lower()
   * @model containment="true"
   * @generated
   */
  Lower getLower();

  /**
   * Sets the value of the '{@link LowerAndOrUpper#getLower <em>Lower</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower</em>' containment reference.
   * @see #getLower()
   * @generated
   */
  void setLower(Lower value);

} // LowerAndOrUpper
