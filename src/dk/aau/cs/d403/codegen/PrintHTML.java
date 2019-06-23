package dk.aau.cs.d403.codegen;

public class PrintHTML {
    public static String StartOfHTML(String fileName) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf8\">\n" +
                "    <!--\n" +
                "\n" +
                "    @license twgl.js Copyright (c) 2015, Gregg Tavares All Rights Reserved.\n" +
                "    Available via the MIT license.\n" +
                "    see: http://github.com/greggman/twgl.js for details\n" +
                "\n" +
                "    -->\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=yes\">\n" +
                "\n" +
                "    <title>" + fileName + "</title>\n" +
                "    <style>\n" +
                "      body {\n" +
                "          margin: 0;\n" +
                "      }\n" +
                "      canvas {\n" +
                "          display: block;\n" +
                "          width: 100vw;\n" +
                "          height: 100vh;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <canvas id=\"c\"></canvas>\n" +
                "  </body>\n" +
                "\n" +
                "\n" +
                "  <!-- VERTEX -->\n" +
                "  \n" +
                "  <script id=\"vs\" type=\"notjs\">\n" +
                "#version 300 es\n" +
                "in vec4 position;\n" +
                "\n" +
                "void main() {\n" +
                "  gl_Position = position;\n" +
                "}\n" +
                "  </script>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <!-- FRAGMENT -->\n" +
                "\n" +
                "  <script id=\"fs\" type=\"notjs\">";
    }

    public static String EndOfHTML() {
        return "\n" +
                "  </script>\n" +
                "  \n" +
                "  \n" +
                "  <!-- TWGL -->\n" +
                "  \n" +
                "  <script src=\"js/twgl.min.js\"></script>\n" +
                "  <script>\n" +
                "    \"use strict\";\n" +
                "    const gl = twgl.getContext(document.getElementById(\"c\"));\n" +
                "    console.log(\"using:\" + gl.getParameter(gl.VERSION));  // eslint-disable-line\n" +
                "    if (!twgl.isWebGL2(gl)) {\n" +
                "        alert(\"Sorry, this shader requires WebGL 2.0\");  // eslint-disable-line\n" +
                "    }\n" +
                "    \n" +
                "    const programInfo = twgl.createProgramInfo(gl, [\"vs\", \"fs\"]);\n" +
                "\n" +
                "    const arrays = {\n" +
                "      position: [-1, -1, 0, 1, -1, 0, -1, 1, 0, -1, 1, 0, 1, -1, 0, 1, 1, 0],\n" +
                "    };\n" +
                "    const bufferInfo = twgl.createBufferInfoFromArrays(gl, arrays);\n" +
                "\n" +
                "    requestAnimationFrame(render);\n" +
                "    \n" +
                "    function render(time) {\n" +
                "      twgl.resizeCanvasToDisplaySize(gl.canvas);\n" +
                "      gl.viewport(0, 0, gl.canvas.width, gl.canvas.height);\n" +
                "\n" +
                "      const uniforms = {\n" +
                "        iTime: time * 0.001,\n" +
                "        iResolution: [gl.canvas.width, gl.canvas.height],\n" +
                "      };\n" +
                "\n" +
                "      gl.useProgram(programInfo.program);\n" +
                "      twgl.setBuffersAndAttributes(gl, programInfo, bufferInfo);\n" +
                "      twgl.setUniforms(programInfo, uniforms);\n" +
                "      twgl.drawBufferInfo(gl, bufferInfo);\n" +
                "\n" +
                "      requestAnimationFrame(render);\n" +
                "    }\n" +
                "  </script>\n" +
                "</html>";
    }
}
