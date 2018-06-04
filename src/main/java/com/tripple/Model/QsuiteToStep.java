package com.tripple.Model;
import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;
import com.tripple.Entity.suiteToStep;


/**
 * QsuiteToStep is a Querydsl query type for suiteToStep
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QsuiteToStep extends EntityPathBase<suiteToStep> {

    private static final long serialVersionUID = 358950571L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QsuiteToStep suiteToStep = new QsuiteToStep("suiteToStep");

    public final QBusinessEntity _super;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> stepId = createNumber("stepId", Long.class);

    public final NumberPath<Integer> stepOrder = createNumber("stepOrder", Integer.class);

    public final NumberPath<Long> testsuiteId = createNumber("testsuiteId", Long.class);

    public final EnumPath<com.tripple.enumType.stepType> type = createEnum("type", com.tripple.enumType.stepType.class);

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    //inherited
    public final NumberPath<Integer> version;

    public QsuiteToStep(String variable) {
        this(suiteToStep.class, forVariable(variable), INITS);
    }

    public QsuiteToStep(Path<? extends suiteToStep> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QsuiteToStep(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QsuiteToStep(PathMetadata<?> metadata, PathInits inits) {
        this(suiteToStep.class, metadata, inits);
    }

    public QsuiteToStep(Class<? extends suiteToStep> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

