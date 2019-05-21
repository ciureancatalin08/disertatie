// =================================================================================================
// Copyright (c) 2017-2020 BMW Group. All rights reserved.
// =================================================================================================
package msg.exeptions;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Message structure for the {@link BusinessException}.
 *
 * @author msg-system ag;
 * @since 1.0
 */
public class ExceptionMessage {

    /** The code used for identifying the message. It can be used to identify the error in other systems.*/
    private String messageCode;

    /** A text message that describes the problems. */
    private String message;


    public ExceptionMessage() {
    }

    public ExceptionMessage(final String messageCode, final String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    /**
     * Getter.
     *
     * @return messageCode
     */
    public String getMessageCode() {
        return this.messageCode;
    }

    /**
     * Getter.
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
