package org.openrndr.draw

import org.openrndr.internal.Driver
import java.nio.ByteBuffer


enum class IndexType {
    INT16,
    INT32
}

interface IndexBuffer {

    companion object {
        fun createDynamic(elementCount: Int, type: IndexType): IndexBuffer = Driver.instance.createDynamicIndexBuffer(elementCount, type)
        //fun createStatic(format: VertexFormat, buffer:Buffer):VertexBuffer
    }

    val indexCount: Int

    val type: IndexType
    fun write(data: ByteBuffer, offset: Int = 0)
    fun destroy()
}

fun indexBuffer(elementCount: Int, type: IndexType): IndexBuffer {
    return IndexBuffer.createDynamic(elementCount, type)
}

