package org.phi.customers

class ImageContent {

    byte[] content

    String type

    static constraints = {
        content maxSize:10000000 // max 10 MB
    }
}
