package com.tripple.Entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * Quser is a Querydsl query type for user
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class Quser extends EntityPathBase<user> {

    private static final long serialVersionUID = 1129384863L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Quser user = new Quser("user");

    public final QBusinessEntity _super;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> createDate;

    public final StringPath Email = createString("Email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<org.joda.time.DateTime> signupDate = createDateTime("signupDate", org.joda.time.DateTime.class);

    // inherited
    public final Quser updateBy;

    //inherited
    public final DateTimePath<org.joda.time.DateTime> updatedDate;

    public final DateTimePath<org.joda.time.DateTime> upDateTime = createDateTime("upDateTime", org.joda.time.DateTime.class);

    public final StringPath userName = createString("userName");

    public final StringPath userPwd = createString("userPwd");

    //inherited
    public final NumberPath<Integer> version;

    public Quser(String variable) {
        this(user.class, forVariable(variable), INITS);
    }

    public Quser(Path<? extends user> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public Quser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public Quser(PathMetadata<?> metadata, PathInits inits) {
        this(user.class, metadata, inits);
    }

    public Quser(Class<? extends user> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QBusinessEntity(type, metadata, inits);
        this.createDate = _super.createDate;
        this.updateBy = _super.updateBy;
        this.updatedDate = _super.updatedDate;
        this.version = _super.version;
    }

}

