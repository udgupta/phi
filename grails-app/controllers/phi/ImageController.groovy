package phi

import org.phi.customers.ImageContent

class ImageController {

    def image() {
        ImageContent image = ImageContent.findById(params.id)
        if (!image || !image.type || !image.content) {
            response.sendError(404)
            return
        }
        response.setContentType(image.type)
        response.setContentLength(image.content.size())
        OutputStream out = response.getOutputStream()
        out.write(image.content)
        out.close()
    }
}
