

/* First created by JCasGen Fri Apr 12 21:25:36 IST 2013 */
package annotation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Related to attachments
 * Updated by JCasGen Sun Apr 14 23:30:42 IST 2013
 * XML source: /home/sridhar/workspace/UIMAwebapp2/desc/emailTypeDescriptor.xml
 * @generated */
public class AttachmentAnnotation extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AttachmentAnnotation.class);
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
  protected AttachmentAnnotation() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AttachmentAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AttachmentAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public AttachmentAnnotation(JCas jcas, int begin, int end) {
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
  //* Feature: hasAttachment

  /** getter for hasAttachment - gets A boolean to indicate whether attachment is present or not.
   * @generated */
  public boolean getHasAttachment() {
    if (AttachmentAnnotation_Type.featOkTst && ((AttachmentAnnotation_Type)jcasType).casFeat_hasAttachment == null)
      jcasType.jcas.throwFeatMissing("hasAttachment", "annotation.AttachmentAnnotation");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((AttachmentAnnotation_Type)jcasType).casFeatCode_hasAttachment);}
    
  /** setter for hasAttachment - sets A boolean to indicate whether attachment is present or not. 
   * @generated */
  public void setHasAttachment(boolean v) {
    if (AttachmentAnnotation_Type.featOkTst && ((AttachmentAnnotation_Type)jcasType).casFeat_hasAttachment == null)
      jcasType.jcas.throwFeatMissing("hasAttachment", "annotation.AttachmentAnnotation");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((AttachmentAnnotation_Type)jcasType).casFeatCode_hasAttachment, v);}    
  }

    