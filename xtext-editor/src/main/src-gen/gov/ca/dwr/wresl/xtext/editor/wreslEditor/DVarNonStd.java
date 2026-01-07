/**
 */
package gov.ca.dwr.wresl.xtext.editor.wreslEditor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DVar Non Std</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link DVarNonStd#getLowerUpper <em>Lower Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see WreslEditorPackage#getDVarNonStd()
 * @model
 * @generated
 */
public interface DVarNonStd extends DVar
{
  /**
   * Returns the value of the '<em><b>Lower Upper</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Upper</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Upper</em>' containment reference.
   * @see #setLowerUpper(LowerAndOrUpper)
   * @see WreslEditorPackage#getDVarNonStd_LowerUpper()
   * @model containment="true"
   * @generated
   */
  LowerAndOrUpper getLowerUpper();

  /**
   * Sets the value of the '{@link DVarNonStd#getLowerUpper <em>Lower Upper</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Upper</em>' containment reference.
   * @see #getLowerUpper()
   * @generated
   */
  void setLowerUpper(LowerAndOrUpper value);

} // DVarNonStd
