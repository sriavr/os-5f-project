

/* First created by JCasGen Fri Mar 22 18:43:38 IST 2013 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** This annotation marks whether current mail item is marked or not, and the time slot to which the email belongs to.
 * Updated by JCasGen Sat Mar 23 16:02:12 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/TimeDetectionAnnotator.xml
 * @generated */
public class TimeDetectionAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TimeDetectionAnnotation.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected TimeDetectionAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public TimeDetectionAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public TimeDetectionAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public TimeDetectionAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
  //*--------------*
  //* Feature: selected

  /** getter for selected - gets selected means the mail is selected if false means ignored.
   * @generated */
  public boolean getSelected() {
    if (TimeDetectionAnnotation_Type.featOkTst && ((TimeDetectionAnnotation_Type)jcasType).casFeat_selected == null)
      jcasType.jcas.throwFeatMissing("selected", "type.TimeDetectionAnnotation");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((TimeDetectionAnnotation_Type)jcasType).casFeatCode_selected);}
    
  /** setter for selected - sets selected means the mail is selected if false means ignored. 
   * @generated */
  public void setSelected(boolean v) {
    if (TimeDetectionAnnotation_Type.featOkTst && ((TimeDetectionAnnotation_Type)jcasType).casFeat_selected == null)
      jcasType.jcas.throwFeatMissing("selected", "type.TimeDetectionAnnotation");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((TimeDetectionAnnotation_Type)jcasType).casFeatCode_selected, v);}    
   
    
  //*--------------*
  //* Feature: timeSlot

  /** getter for timeSlot - gets 
   * @generated */
  public int getTimeSlot() {
    if (TimeDetectionAnnotation_Type.featOkTst && ((TimeDetectionAnnotation_Type)jcasType).casFeat_timeSlot == null)
      jcasType.jcas.throwFeatMissing("timeSlot", "type.TimeDetectionAnnotation");
    return jcasType.ll_cas.ll_getIntValue(addr, ((TimeDetectionAnnotation_Type)jcasType).casFeatCode_timeSlot);}
    
  /** setter for timeSlot - sets  
   * @generated */
  public void setTimeSlot(int v) {
    if (TimeDetectionAnnotation_Type.featOkTst && ((TimeDetectionAnnotation_Type)jcasType).casFeat_timeSlot == null)
      jcasType.jcas.throwFeatMissing("timeSlot", "type.TimeDetectionAnnotation");
    jcasType.ll_cas.ll_setIntValue(addr, ((TimeDetectionAnnotation_Type)jcasType).casFeatCode_timeSlot, v);}    
  }

    