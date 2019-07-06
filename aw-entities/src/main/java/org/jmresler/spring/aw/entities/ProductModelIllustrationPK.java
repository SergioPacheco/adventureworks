package org.jmresler.spring.aw.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author John
 */
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ProductModelIllustrationPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8275846653749384794L;
	@Basic(optional = false)
    @Column(name = "ProductModelID", nullable = false)
    private int productModelID;
    @Basic(optional = false)
    @Column(name = "IllustrationID", nullable = false)
    private int illustrationID;
}
