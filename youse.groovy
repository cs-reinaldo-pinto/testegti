//====================== AUTHENTICATION ==========================

node('master'){
	
	stage 'testAuthentication'
	checkout scm
	print "Estou no MASTER testAuthentication."

checkout([$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, recursiveSubmodules: true, reference: '', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5cb777fb-b8e5-4638-8f25-0a6dc5fa0d02', url: 'git@github.com:youse-seguradora/components-authenticationi.git']]])

//	checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-authentication.git']]]

	def nodeHome = tool name: 'Default Version (5.10.0)'
	env.PATH="${env.PATH}:${nodeHome}/bin"
}

node('changemore'){

	stage 'deployAuthentication'
	checkout scm
	print "Estou no CHANGEMORE deployAuthentication"

checkout([$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, recursiveSubmodules: true, reference: '', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5cb777fb-b8e5-4638-8f25-0a6dc5fa0d02', url: 'git@github.com:youse-seguradora/components-authentication.git']]])

//	checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-authentication.git']]]
	
	sh 'cd deploy && ./start_environment.sh'	
}

//====================== EVENTS ==========================

node('master'){
	
	stage 'testEvents'
	checkout scm
	print "Estou no MASTER testEvents."

checkout([$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, recursiveSubmodules: true, reference: '', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5cb777fb-b8e5-4638-8f25-0a6dc5fa0d02', url: 'git@github.com:youse-seguradora/components-ipr.git']]])

// checkout([$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, recursiveSubmodules: true, reference: './shared-libs', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-ipr.git']]])

//	checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-ipr.git']]]

sh '''cd "components"
	echo "Executando os consumers."
	for DIR in `/bin/ls -d */`; do
	cd "$DIR/consumer/" 
	echo "Instalando dependências!! $DIR" 
	npm install && npm run test && cd -
done'''
}

node('changemore'){

	stage 'deployEvents'
	checkout scm
	print "Estou no CHANGEMORE deployEvents"

checkout([$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, recursiveSubmodules: true, reference: '', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '5cb777fb-b8e5-4638-8f25-0a6dc5fa0d02', url: 'git@github.com:youse-seguradora/components-ipr.git']]])

//checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-ipr.git']]]

	sh 'cd deploy && ./start_environment.sh'	
}

//====================== NOTIFICATIONS ==========================

node('master'){
	
	stage 'testNotifications'
	checkout scm
	print "Estou no MASTER testNotifications."

//	checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-notifications.git']]]

	def nodeHome = tool name: 'Default Version (5.10.0)'
	env.PATH="${env.PATH}:${nodeHome}/bin"

//	sh 'cd "components/notifications/consumer" && npm build'
}

node('changemore'){

	stage 'deployNotifications'
	checkout scm
	print "Estou no CHANGEMORE deployNotifications"

	//checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-notifications.git']]]
	
	//sh 'cd deploy && ./start_environment.sh'	
}

//====================== Manager ==========================

node('master'){
	
	stage 'testManager'
	checkout scm
	print "Estou no MASTER testManager."

	//checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-manager.git']]]

	def nodeHome = tool name: 'Default Version (5.10.0)'
	env.PATH="${env.PATH}:${nodeHome}/bin"

	//sh 'cd "components-manager" && npm build'
}

node('changemore'){

	stage 'deployManager'
	checkout scm
	print "Estou no CHANGEMORE deployManager"

//	checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/development']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '3dc6d6aa-a9e9-44e7-b485-dc1f38601277', url: 'git@github.com:youse-seguradora/components-manager.git']]]
	
	//sh 'cd deploy && ./start_environment.sh'	
}

