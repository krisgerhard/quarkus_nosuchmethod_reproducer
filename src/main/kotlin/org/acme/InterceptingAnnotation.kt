package org.acme

import jakarta.interceptor.InterceptorBinding
import java.lang.annotation.Inherited
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION

@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target(CLASS, FUNCTION)
annotation class InterceptingAnnotation
