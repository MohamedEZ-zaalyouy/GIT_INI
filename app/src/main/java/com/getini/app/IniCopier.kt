package com.getini.app

import android.content.Context
import java.io.File
import java.io.IOException

object IniCopier {

    private const val SOURCE = "/storage/emulated/0/.INI/METI_Mob.ini"
    private const val DESTINATION = "/storage/emulated/0/METI_Mob.ini"

    data class Result(val success: Boolean, val message: String)

    fun copyIni(context: Context): Result {
        return try {
            val source = File(SOURCE)
            val destination = File(DESTINATION)

            if (!source.exists()) {
                return Result(false, "✗ Source introuvable : $SOURCE")
            }

            if (!source.isFile) {
                return Result(false, "✗ La source n'est pas un fichier.")
            }

            destination.parentFile?.mkdirs()

            source.inputStream().use { input ->
                destination.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            val sourceLength = source.length()
            val destinationLength = destination.length()

            if (sourceLength != destinationLength) {
                return Result(false, "✗ Copie vérification échouée.")
            }

            Result(true, "✓ Copie réussie\n$DESTINATION")
        } catch (e: IOException) {
            Result(false, "✗ Erreur fichier : ${e.message}")
        } catch (e: SecurityException) {
            Result(false, "✗ Accès refusé au stockage Android.")
        } catch (e: Exception) {
            Result(false, "✗ Erreur : ${e.message}")
        }
    }
}
