/**
* <ul>
* Android Tutorial, An <strong>Android2EE</strong>'s project.</br>
* Produced by <strong>Dr. Mathias SEGUY</strong> with the smart contribution of <strong>Julien PAPUT</strong>.</br>
* Delivered by <strong>http://android2ee.com/</strong></br>
* Belongs to <strong>Mathias Seguy</strong></br>
* ****************************************************************************************************************</br>
* This code is free for any usage but can't be distribute.</br>
* The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
* The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* For any information (Advice, Expertise, J2EE or Android Training, Rates, Business):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
* Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br>
* Sa propriété intellectuelle appartient à <strong>Mathias Séguy</strong>.</br>
* <em>http://mathias-seguy.developpez.com/</em></br>
* </br>
* Pour tous renseignements (Conseil, Expertise, Formations J2EE ou Android, Prestations, Forfaits):</br>
* <em>mathias.seguy.it@gmail.com</em></br>
* *****************************************************************************************************************</br>
* Merci à vous d'avoir confiance en Android2EE les Ebooks de programmation Android.
* N'hésitez pas à nous suivre sur twitter: http://fr.twitter.com/#!/android2ee
* N'hésitez pas à suivre le blog Android2ee sur Developpez.com : http://blog.developpez.com/android2ee-mathias-seguy/
* *****************************************************************************************************************</br>
* com.android2ee.android.tuto</br>
* 25 mars 2011</br>
*/
package com.android2ee.android.tuto.gui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

/**
 * @author (Julien PAPUT sous la direction du Dr. Mathias Séguy)
 * @goals
 * This class aims to:
 * <ul><li>Ask to the User what he like and show the result.</li></ul>
 */
public class CheckBoxTuto extends Activity {
	
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	/**  The chocolate CheckBox */
	CheckBox checkBoxChoco;
	/**  The television CheckBox */
	CheckBox checkBoxTele;
	/**  The internet CheckBox */
	CheckBox checkInternet;
	/**  The nicotine CheckBox */
	CheckBox checkNicotine;
	/**  The hug CheckBox */
	CheckBox checkHug;
	/**  The santa CheckBox */
	CheckBox checkSanta;
	
	/******************************************************************************************/
	/** Méthodes **************************************************************************/
	/******************************************************************************************/


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		/******************************************************************************************/
		/** CheckBox instanciation ****************************************************************/
		/******************************************************************************************/
		// Instanciate the checkboxs
		checkBoxChoco = (CheckBox) findViewById(R.id.checkchocolate);
		checkBoxTele = (CheckBox) findViewById(R.id.checktelevision);
		checkInternet = (CheckBox) findViewById(R.id.checkinternet);
		checkNicotine = (CheckBox) findViewById(R.id.checknicotine);
		checkHug = (CheckBox) findViewById(R.id.checkhug);
		checkSanta = (CheckBox) findViewById(R.id.checksanta);
		
		/******************************************************************************************/
		/** Adding listeners **************************************************************************/
		/******************************************************************************************/
		// Adding a click listener on the checkBox Chocolate that react when the
		// user click on
		checkBoxChoco.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				onChocolatChecked(isChecked);

			}

			
		});
		// Adding a click listener on the checkBox Santaclaus
		checkSanta.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				String text = "on : " + buttonView.getText() + " isChecked :" + isChecked;
				Toast.makeText(CheckBoxTuto.this, text, Toast.LENGTH_SHORT).show();
			}
		});
		
		/******************************************************************************************/
		/** Retrieve the selection ****************************************************************/
		/******************************************************************************************/
		// Define the button that show the Toaster
		Button btn = (Button) findViewById(R.id.btnShow);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showChoices();
			}
		});
	}
	/**
	 * @param isChecked
	 */
	private void onChocolatChecked(boolean isChecked) {
		if (isChecked) {
			Toast.makeText(CheckBoxTuto.this, "Me too i like so much chocolate",
					Toast.LENGTH_SHORT).show();
		}
	}

	/**showChoices()
	Make a text message and Show it in a Toaster.
	*/
	private void showChoices() {
		StringBuilder text = new StringBuilder( getString(R.string.choice));
		text.append(" ");
		// if the android checkbox is checked, add "Android" to the string
		if (checkBoxChoco.isChecked()) {
			text.append(getString(R.string.chocolate));
		}
		// if the iphone checkbox is checked, add "Iphone" to the string
		if (checkBoxTele.isChecked()) {
			text.append(getString(R.string.television));
		}
		// if the blackberry checkbox is checked, add "Blackberry" to the string
		if (checkInternet.isChecked()) {
			text.append(getString(R.string.internet));
		}
		// if the android checkbox is checked, add "Android" to the string
		if (checkNicotine.isChecked()) {
			text.append(getString(R.string.nicotine));
		}
		// if the iphone checkbox is checked, add "Iphone" to the string
		if (checkHug.isChecked()) {
			text.append(getString(R.string.hug));
		}
		// if the blackberry checkbox is checked, add "Blackberry" to
		// the string
		if (checkSanta.isChecked()) {
			text.append(getString(R.string.santaclaus));
		}
		// Make and Show the Toaster
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
	}
}