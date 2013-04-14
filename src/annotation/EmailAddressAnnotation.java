

/* First created by JCasGen Fri Apr 12 21:36:27 IST 2013 */
package annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringList;
import org.apache.uima.jcas.tcas.Annotation;


/** to store annotation related to email.
 * Updated by JCasGen Sun Apr 14 23:30:43 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/emailTypeDescriptor.xml
 * @generated */
public class EmailAddressAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(EmailAddressAnnotation.class);
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
  protected EmailAddressAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public EmailAddressAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public EmailAddressAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public EmailAddressAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: senderEmail

  /** getter for senderEmail - gets 
   * @generated */
  public String getSenderEmail() {
    if (EmailAddressAnnotation_Type.featOkTst && ((EmailAddressAnnotation_Type)jcasType).casFeat_senderEmail == null)
      jcasType.jcas.throwFeatMissing("senderEmail", "annotation.EmailAddressAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((EmailAddressAnnotation_Type)jcasType).casFeatCode_senderEmail);}
    
  /** setter for senderEmail - sets  
   * @generated */
  public void setSenderEmail(String v) {
    if (EmailAddressAnnotation_Type.featOkTst && ((EmailAddressAnnotation_Type)jcasType).casFeat_senderEmail == null)
      jcasType.jcas.throwFeatMissing("senderEmail", "annotation.EmailAddressAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((EmailAddressAnnotation_Type)jcasType).casFeatCode_senderEmail, v);}    
   
    
  //*--------------*
  //* Feature: recepientEmail

  /** getter for recepientEmail - gets 
   * @generated */
  public StringList getRecepientEmail() {
    if (EmailAddressAnnotation_Type.featOkTst && ((EmailAddressAnnotation_Type)jcasType).casFeat_recepientEmail == null)
      jcasType.jcas.throwFeatMissing("recepientEmail", "annotation.EmailAddressAnnotation");
    return (StringList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((EmailAddressAnnotation_Type)jcasType).casFeatCode_recepientEmail)));}
    
  /** setter for recepientEmail - sets  
   * @generated */
  public void setRecepientEmail(StringList v) {
    if (EmailAddressAnnotation_Type.featOkTst && ((EmailAddressAnnotation_Type)jcasType).casFeat_recepientEmail == null)
      jcasType.jcas.throwFeatMissing("recepientEmail", "annotation.EmailAddressAnnotation");
    jcasType.ll_cas.ll_setRefValue(addr, ((EmailAddressAnnotation_Type)jcasType).casFeatCode_recepientEmail, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    