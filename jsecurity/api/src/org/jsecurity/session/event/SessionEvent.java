/*
 * Copyright (C) 2005 Les A. Hazlewood
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General
 * Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the
 *
 * Free Software Foundation, Inc.
 * 59 Temple Place, Suite 330
 * Boston, MA 02111-1307
 * USA
 *
 * Or, you may view it online at
 * http://www.opensource.org/licenses/lgpl-license.php
 */
package org.jsecurity.session.event;

import java.util.Calendar;
import java.util.EventObject;
import java.io.Serializable;

/**
 * General event concerning a {@link org.jsecurity.session.Session} instance.
 *
 * @author Les Hazlewood
 */
public abstract class SessionEvent extends EventObject {

    protected Calendar timestamp = Calendar.getInstance();

    protected final Serializable sessionId;

    public SessionEvent( Serializable sessionId ) {
        /* Dummy source.  Most times we don't care about the object that actually generates the
           event in a client-server system (which is usually the SessionManager). */
        this( new Object(), sessionId );
    }

    public SessionEvent( Object source, Serializable sessionId ) {
        super( source );
        this.sessionId = sessionId;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp( Calendar timestamp ) {
        this.timestamp = timestamp;
    }
}
